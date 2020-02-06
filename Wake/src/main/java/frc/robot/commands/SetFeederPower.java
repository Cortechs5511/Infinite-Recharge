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
    if ((m_Feeder.getBottomSensor.get() == false) && (m_Feeder.getTopSensor.get())) { //move up a stage
      m_Feeder.setFeederSpeed(0.4);
    } else if (m_Shooter.targetReached){ //feed to shoot
      m_Feeder.setFeederSpeed(0.4);
    } else {
      m_Feeder.setFeederSpeed(0); //none of the above
    }

    if ((m_oi.getFeeder.get()) && (m_Feeder.getBottomSensor.get())) { //if button is pressed and bottom sensor is open, feeder spins
      m_Feeder.setFeeder2Speed(0.4);
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