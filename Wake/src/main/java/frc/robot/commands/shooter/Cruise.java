package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;
import frc.robot.OI;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;

public class Cruise extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Shooter m_shooter;
  private Feeder m_feeder;
  private Limelight m_limelight;

  private OI m_oi = OI.getInstance();
  private double count = 0f;

  public Cruise(Shooter shooter, Feeder feeder, Limelight limelight) {
    m_shooter = shooter;
    m_feeder = feeder;
    m_limelight = limelight;
    addRequirements(shooter);
    addRequirements(feeder);
    addRequirements(limelight);
  }

  @Override
  public void initialize() {
    m_feeder.setFeederSpeed(0.4);
    m_feeder.setFeeder2Speed(0.4);
    m_feeder.setFeeder3Speed(0.4);
  }

  @Override
  public void execute() {
    if (m_feeder.getTopSensor.get() == false) { // if there is a ball in the top, timer resets
      count = 0;
    } else { // else (there is no ball, or the sensor is dead), timer starts counting
      count++;
    }

    if ((count > 25) && (count < 75)) {
      m_oi.setLeftRumble(1);
      m_oi.setRightRumble(1);
    } else {
      m_oi.setLeftRumble(0);
      m_oi.setRightRumble(0);
    }

    if (m_shooter.getSpeed.get() < 1000) {
      m_feeder.setFeederSpeed(0);
      m_feeder.setFeeder2Speed(0);
      m_feeder.setFeeder3Speed(0);
    } else {
      m_feeder.setFeederSpeed(0.4);
      m_feeder.setFeeder2Speed(0.4);
      m_feeder.setFeeder3Speed(0.4);
    }
  }

  @Override
  public void end(boolean interrupted) {
    count = 0;
    m_limelight.setLightStatus(1);

    m_shooter.setRampRate(1.5);
    m_shooter.setPIDReference(0);
    m_shooter.setSpeed(0);
    m_shooter.targetReached = false;

    m_feeder.setFeederSpeed(0);
    m_feeder.setFeeder2Speed(0);
  }

  @Override
  public boolean isFinished() {
    return (count > 100); // about 2 seconds of pause
  }
}