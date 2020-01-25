package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.OI;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetFeederPower extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private Intake m_Intake;

  public SetFeederPower(Intake subsystem) {
    m_Intake = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_Intake.resetFeedEncoder();
    /* needs to be updated with actual value */
    /* to do - figure out switch integration as error checking */
    int x = 0;
    if (m_Intake.getFeedEncoder.get() < x) {
      m_Intake.setFeederSpeed(0.9);
    }
    else {
      m_Intake.setFeederSpeed(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_Intake.setFeederSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}