package frc.robot.commands.shooter;

import frc.robot.OI;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Accel extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Shooter m_Shooter;
  private OI m_oi = OI.getInstance();
  private Limelight m_Limelight;
  private double currentSpeed, calculatedRPM;
  private int count = 0;

  public Accel(Shooter shooter, Limelight limelight) {
    m_Shooter = shooter;
    m_Limelight = limelight;
    addRequirements(shooter);
    addRequirements(limelight);
  }

  @Override
  public void initialize() {
    m_Shooter.setRampRate(1.5);
    calculatedRPM = m_Limelight.calculateRPM();
    m_Shooter.setPIDReference(calculatedRPM);
  }

  @Override
  public void execute() {
    currentSpeed = m_Shooter.getSpeed.get(); 
    SmartDashboard.putNumber("RPM compare count", count);

    if (Math.abs(calculatedRPM - currentSpeed) < 200) { 
      count++;
    } else {
      count = 0;
    }

    if (count != 0) {
      m_oi.setLeftRumble(0.3);
      m_oi.setRightRumble(0.3);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.targetReached = true;
    m_Shooter.setRampRate(0.15);
    count = 0;

    m_oi.setLeftRumble(0);
    m_oi.setRightRumble(0);
  }

  @Override
  public boolean isFinished() {
    return (count > 25);
  }
}