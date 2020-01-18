package frc.robot.commands;

import frc.robot.subsystems.Drive;
import frc.robot.OI;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetSpeed extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private double leftInput;
  private double rightInput;
  private Drive m_drive;

  public SetSpeed(Drive subsystem) {
    m_drive = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    leftInput = m_oi.leftStick.getY();
    rightInput = m_oi.rightStick.getY();

    if (Math.abs(leftInput) > 0.05) {
      m_drive.left.set(leftInput * 0.9);
    }
    else {
      m_drive.left.set(0);
    }
    if (Math.abs(rightInput) > 0.05) {
      m_drive.right.set(rightInput * 0.9);
    }
    else {
      m_drive.right.set(0);
    }
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
