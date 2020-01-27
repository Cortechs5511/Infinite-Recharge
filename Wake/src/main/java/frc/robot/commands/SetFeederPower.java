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
    if (m_Intake.getTopSensor.get() == false) { //means there is a ball in top sensors
      m_Intake.setFeederSpeed(0);
    } else if (m_Intake.getBottomSensor.get() == false) { //means there is no ball in the top sensor, ball in the bottom sensor
      m_Intake.setFeederSpeed(0.5);
    } else {
      m_Intake.setFeederSpeed(0); // no ball in the top or bottom sensor
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