package frc.robot.commands;

import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Shooter;
import frc.robot.OI;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetFeederPower extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Feeder m_Feeder;
  private Shooter m_Shooter;
  private OI m_oi = OI.getInstance();

  public SetFeederPower(Feeder feeder, Shooter shooter) {
    m_Feeder = feeder;
    m_Shooter = shooter;
    addRequirements(feeder);
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    m_Feeder.resetFeedEncoder();
  }

  @Override
  public void execute() { 
    /*if ((m_Feeder.getTopSensor.get() == false) && (m_Shooter.targetReached))  { //means there is a ball in top sensors
      m_Feeder.setFeederSpeed(0);
    } else if ((m_Feeder.getBottomSensor.get() == false) || (m_Shooter.targetReached)) { //means there is no ball in the top sensor, ball in the bottom sensor
      m_Feeder.setFeederSpeed(0.5);
    } else {
      m_Feeder.setFeederSpeed(0); // no ball in the top or bottom sensor
    }*/

    if ((m_Feeder.getBottomSensor.get() == false) && (m_Feeder.getTopSensor.get())) { //move up a stage
      m_Feeder.setFeederSpeed(0.5);
    } else if (m_Shooter.targetReached){ //feed to shoot
      m_Feeder.setFeederSpeed(0.5);
    } else {
      m_Feeder.setFeederSpeed(0); //none of the above
    }

    if ((m_oi.getIntake.get()) && (m_Feeder.getBottomSensor.get())) { //if button is pressed and bottom sensor is open, feeder spins
      m_Feeder.setFeeder2Speed(0.9);
    } else {
      m_Feeder.setFeeder2Speed(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_Feeder.setFeederSpeed(0);
    m_Feeder.setFeeder2Speed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}