package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;

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
    if (input == true) {
      m_Intake.intake.set(ControlMode.PercentOutput, 0.9);
    }
    else {
      m_Intake.intake.set(ControlMode.PercentOutput, 0);
    }
    if ((m_oi.getIntake.get() == true) && (m_Intake.getBottomSensor.get() == false)) {
      m_Intake.setFeeder0Speed(0.9);
    }
  }

  @Override
  public void end(boolean interrupted) {
      m_Intake.intake.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}