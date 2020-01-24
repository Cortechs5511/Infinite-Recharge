package frc.robot.commands;

import frc.robot.subsystems.Drive;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drive m_drive;

  public SetDistance(Drive subsystem) {
    m_drive = subsystem;
    addRequirements(subsystem);
  }
  private double targetDistance;

  @Override
  public void initialize() {
    m_drive.leftenc.setPosition(0);
    m_drive.rightenc.setPosition(0);
  }

  @Override
  public void execute() {
    m_drive.leftNEOPID.setReference(targetDistance, ControlType.kPosition);
    m_drive.left1.set(m_drive.left0.get());

    m_drive.rightNEOPID.setReference(targetDistance, ControlType.kPosition);
    m_drive.right1.set(m_drive.left0.get());

    SmartDashboard.putNumber("PID Command", m_drive.left0.get());
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
