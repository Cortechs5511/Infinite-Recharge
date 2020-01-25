package frc.robot.commands.drive;

import frc.robot.subsystems.Drive;
import frc.robot.OI;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetSpeed extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private double leftInput;
  private double rightInput;
  private Drive m_drive;

  public SetSpeed(Drive drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    leftInput = m_oi.getLeftY.get();
    rightInput = m_oi.getLeftY.get();

    if (Math.abs(leftInput) > 0.05) {
      m_drive.setLeft(leftInput * 0.9);
    }
    else {
      m_drive.setLeft(0);
    }
    if (Math.abs(rightInput) > 0.05) {
      m_drive.setRight(rightInput * 0.9);
    }
    else {
      m_drive.setRight(0);
    }  
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
