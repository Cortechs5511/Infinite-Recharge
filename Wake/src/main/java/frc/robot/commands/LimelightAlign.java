package frc.robot.commands;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Limelight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LimelightAlign extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drive m_drive;
  private Limelight m_limelight;

  public LimelightAlign(Drive drive, Limelight limelight) {
    m_drive = drive;
    m_limelight = limelight;
    addRequirements(drive);
    addRequirements(limelight);
  }

  @Override
  public void initialize() {
    SmartDashboard.putNumber("Angle P", 0.0);
    SmartDashboard.putNumber("Angle I", 0.0);
    SmartDashboard.putNumber("Angle D", 0.0);
    SmartDashboard.putNumber("Angle PID Setpoint", 0.0);
  }

  @Override
  public void execute() {
    double angle_kP = SmartDashboard.getNumber("Angle P", 0.0);
    double angle_kI = SmartDashboard.getNumber("Angle I", 0.0);
    double angle_kD = SmartDashboard.getNumber("Angle D", 0.0);
    double setpoint = 0.0;
    m_drive.anglePID.setPID(angle_kP, angle_kI, angle_kD);
    m_drive.anglePID.setSetpoint(setpoint);
    double val = m_drive.anglePID.calculate(m_limelight.x, setpoint);
    m_drive.left.set(val);
    m_drive.right.set(-val);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.left.stopMotor();
    m_drive.right.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
