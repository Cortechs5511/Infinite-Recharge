package frc.robot.commands.drive;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LimelightAlign extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drive m_drive;
  private Limelight m_limelight;
  private double val;
  double angle_kP, angle_kI, angle_kD;
  private double input;
  private double threshold = 0.5;

  public LimelightAlign(Drive drive, Limelight limelight) {
    m_drive = drive;
    m_limelight = limelight;
    addRequirements(drive);
    addRequirements(limelight);
  }

  @Override
  public void initialize() {
    SmartDashboard.putNumber("Angle P", 0);
    SmartDashboard.putNumber("Angle I", 0);
    SmartDashboard.putNumber("Angle D", 0);
  }

  @Override
  public void execute() {
    input = m_limelight.getX();
    SmartDashboard.putNumber("Limelight Received X", input);
    double setpoint = 0.0;

    angle_kP = SmartDashboard.getNumber("Angle P", 0);
    angle_kI = SmartDashboard.getNumber("Angle I", 0);
    angle_kD = SmartDashboard.getNumber("Angle D", 0);

    m_drive.anglePID.setPID(angle_kP, angle_kI, angle_kD);
    val = m_drive.anglePID.calculate(input, setpoint);
    SmartDashboard.putNumber("Raw Val", val);

    if (Math.abs(val) > 0.8) {
      val = (0.8 * val / Math.abs(val));
    } else if (Math.abs(val) < 0.05) {
      val = 0;
    }
    SmartDashboard.putNumber("Post Deadband/Max Val", val);
    m_drive.setLeft(val);
    m_drive.setRight(-val);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.setLeft(0);
    m_drive.setRight(0);
  }

  @Override
  public boolean isFinished() {
    if ((Math.abs(input) < threshold) && ((m_drive.getLeftVelocity.get() == 0) && (m_drive.getRightVelocity.get() == 0))) {
      return true;
    } else {
      return false;
    }
  }
}
