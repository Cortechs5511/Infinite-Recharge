package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetWristPower extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private Intake m_Intake;
  private double input = 0;

  public SetWristPower(Intake subsystem) {
    m_Intake = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (m_oi.getWristDown() == true) {
        input = -0.9;
    }
    else if (m_oi.getWristUp() == true) {
        input = 0.9;
    }
    else {
        input = 0;
    }
    m_Intake.wrist.set(ControlMode.PercentOutput, input);
  }

  @Override
  public void end(boolean interrupted) {
      m_Intake.wrist.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}