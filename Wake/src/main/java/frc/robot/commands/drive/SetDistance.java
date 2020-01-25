package frc.robot.commands.drive;

import frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drive m_drive;

  public SetDistance(Drive drive) {
    m_drive = drive;
    addRequirements(drive);
  }
  private double targetDistance;

  @Override
  public void initialize() {
    m_drive.resetLeftEnc();
    m_drive.resetRightEnc();
  }

  @Override
  public void execute() {
    m_drive.setLeftPIDReference(targetDistance);
    m_drive.setRightPIDReference(targetDistance);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.setLeft(0);
    m_drive.setLeft(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
