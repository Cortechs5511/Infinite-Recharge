package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.OI;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetIntakePower extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private Intake m_Intake;
  private Boolean input = false;

  public SetIntakePower(Intake subsystem) {
    m_Intake = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    input = m_oi.getIntake();
    if (input == true) {
      m_Intake.pullBallIn();
    }
    else {
        m_Intake.stopBall();
    }
  }

  @Override
  public void end(boolean interrupted) {
      m_Intake.stopBall();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}