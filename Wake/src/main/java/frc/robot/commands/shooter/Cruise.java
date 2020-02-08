package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;

public class Cruise extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private Shooter m_Shooter;
  private Feeder m_Feeder;

  private boolean exit = false;
  private double count = 0f;

  public Cruise(Shooter shooter, Feeder feeder) {
    m_Shooter = shooter;
    m_Feeder = feeder;
    addRequirements(m_Shooter);
    addRequirements(m_Feeder);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (m_Feeder.getTopSensor.get() == false) { // if there is a ball in the top, timer resets
      count = 0;
    } else { // else (there is no ball, or the sensor is dead), timer starts counting
      count++;
    }
  }

  @Override
  public void end(boolean interrupted) {
    count = 0;
    m_Shooter.setRampRate(1.5);
    m_Shooter.setPIDReference(0);
    m_Shooter.setSpeed(0);
    m_Shooter.targetReached = false;
  }

  @Override
  public boolean isFinished() {
    if (count > 50) { // if timer is greater than 1 second, shooter stops
      return true; // if the last ball is falling short, increase to 1.5 seconds (suggestion)
    } else {
      return false;
    }
  }
}