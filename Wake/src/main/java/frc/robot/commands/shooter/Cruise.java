package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;

public class Cruise extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Timer timer = new Timer();
  
  private Shooter m_Shooter;
  private Feeder m_Feeder; 

  private boolean exit = false;

  public Cruise(Shooter shooter, Feeder feeder) {
    m_Shooter = shooter;
    m_Feeder = feeder;
    addRequirements(m_Shooter);
    addRequirements(m_Feeder);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    if (m_Feeder.getTopSensor.get() == false) { // if there is a ball in the top, timer resets
      timer.reset();
    } else { // else (there is no ball, or the sensor is dead), timer starts counting
      timer.start();
    }
    if (timer.get() > 1) { // if timer is greater than 1 second, shooter stops
      exit = true; //if the last ball is falling short, increase to 1.5 seconds
    } else {
      exit = false;
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.setRampRate(1.5);
    m_Shooter.setPIDReference(0);
    m_Shooter.setSpeed(0);
  }

  @Override
  public boolean isFinished() {
      return exit;
  }
}