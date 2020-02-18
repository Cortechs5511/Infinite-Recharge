package frc.robot.commands.shooter;

import frc.robot.OI;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Limelight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AccelLimelight extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Shooter m_Shooter;
  private Drive m_Drive;
  private OI m_oi = OI.getInstance();
  private Limelight m_Limelight;
  private double currentSpeed, calculatedRPM;
  private int count = 0;
  private double val;
  private double input;
  private double threshold = 0.5;
  private boolean end = false;

  public AccelLimelight(Shooter shooter, Limelight limelight, Drive drive) {
    m_Shooter = shooter;
    m_Limelight = limelight;
    m_Drive = drive;
    addRequirements(shooter);
    addRequirements(limelight);
    SmartDashboard.putBoolean("Limelight Align Active", true);
    m_Drive.anglePID.reset();
  }

  @Override
  public void initialize() {
    m_Shooter.setRampRate(1.5);
    calculatedRPM = m_Limelight.calculateRPM();
    m_Shooter.setPIDReference(calculatedRPM);
    SmartDashboard.putNumber("Limelight Calculated RPM", calculatedRPM);
  }

  @Override
  public void execute() {
    currentSpeed = m_Shooter.getSpeed.get(); 
    SmartDashboard.putNumber("RPM compare count", count);
    input = m_Limelight.getX();
    threshold = SmartDashboard.getNumber("Threshold", 0.5);
    SmartDashboard.putNumber("Limelight Received X", input);
    double setpoint = 0.0;

    val = m_Drive.anglePID.calculate(input, setpoint);
    SmartDashboard.putNumber("Raw Val", val);

    if (Math.abs(val) > 0.35) {
      val = (0.35 * val / Math.abs(val));
    } else if (Math.abs(val) < 0.05) {
      val = 0;
    }
    SmartDashboard.putNumber("Post Deadband Val", val);
    m_Drive.setLeft(val);
    m_Drive.setRight(-val);
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.targetReached = true;
    m_Shooter.setRampRate(0.15);
    count = 0;
    m_Drive.setLeft(0);
    m_Drive.setRight(0);
    SmartDashboard.putBoolean("Limelight Align Active", false);
  }

  @Override
  public boolean isFinished() {
    if (Math.abs(calculatedRPM - currentSpeed) < 200) { // about a 1/2 second
      count++;
    } else {
      count = 0;
    }

    if (count != 0) {
      m_oi.setLeftRumble(0.3);
      m_oi.setRightRumble(0.3);
    }

    if (count > 25) {
      end = true;
      //return true;
    } else {
      end = false;
      //return false;
    }

    if ((Math.abs(input) < threshold) && (m_Drive.getLeftVelocity.get() < 30) && (m_Drive.getRightVelocity.get() < 30)) { 
      if (end) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}