package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Limelight;

public class LightToggle extends InstantCommand {
  private Limelight m_limelight;

  public LightToggle(Limelight limelight) {
    addRequirements(limelight);
  }

  @Override
  public void initialize() {
    double current = m_limelight.getLightStatus();
    if (current == 1) {
      m_limelight.setLightStatus(3);
    } else {
      m_limelight.setLightStatus(1);
    }
  }
}
