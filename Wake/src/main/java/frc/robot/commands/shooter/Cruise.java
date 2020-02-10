package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;

public class Cruise extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private Shooter m_shooter;
  private Feeder m_feeder;
  private double count = 0f;

  public Cruise(Shooter shooter, Feeder feeder) {
    m_shooter = shooter;
    m_feeder = feeder;
    addRequirements(m_shooter);
    addRequirements(m_feeder);
  }

  @Override
  public void initialize() {
    m_feeder.setFeederSpeed(0.4);
    m_feeder.setFeeder2Speed(0.4);
  }

  @Override
  public void execute() {
    if (m_feeder.getTopSensor.get() == false) { // if there is a ball in the top, timer resets
      count = 0;
    } else { // else (there is no ball, or the sensor is dead), timer starts counting
      count++;
    }
  }

  @Override
  public void end(boolean interrupted) {
    count = 0;
    m_shooter.setRampRate(1.5);
    m_shooter.setPIDReference(0);
    m_shooter.setSpeed(0);
    m_shooter.targetReached = false;

    m_feeder.setFeederSpeed(0);
    m_feeder.setFeeder2Speed(0);
  }

  @Override
  public boolean isFinished() {
    if (count > 100) {
      return true;
    } else {
      return false;
    }
  }
}