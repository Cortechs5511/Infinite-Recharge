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
    input = m_oi.getIntake.get();
    if (input == true) { // if button is pressed, intake spins
      m_Intake.setIntakePower(0.9);
    } else {
      m_Intake.setIntakePower(0);
    }
    if ((input == true) && (m_Intake.getBottomSensor.get() == true)) { //if button is pressed and bottom sensor is open, feeder spins
      m_Intake.setFeeder2Speed(0.9);
    } else {
      m_Intake.setFeeder2Speed(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
      m_Intake.setIntakePower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}