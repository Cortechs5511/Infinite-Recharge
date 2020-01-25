package frc.robot.commands;

import frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetFeederPower extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Intake m_Intake;

  public SetFeederPower(Intake subsystem) {
    m_Intake = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    m_Intake.resetFeedEncoder();
  }

  @Override
  public void execute() { 
    if (m_Intake.getTopSensor.get() == true) {
      m_Intake.setFeederSpeed(0);
    }
    else if (m_Intake.getBottomSensor.get() == true) {
      m_Intake.setFeederSpeed(0.5);
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