package frc.robot.commands;

import frc.robot.subsystems.Feeder;
import frc.robot.OI;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetFeederPower extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Feeder m_feeder;
  private OI m_oi = OI.getInstance();
  private double feederPower, feeder2Power, feeder3Power;

  public SetFeederPower(Feeder feeder) {
    m_feeder = feeder;
    addRequirements(feeder);
  }

  @Override
  public void initialize() {
    m_feeder.resetFeedEncoder();
  }

  @Override
  public void execute() {
    boolean bottomOpen = m_feeder.getBottomSensor.get();
    boolean topOpen = m_feeder.getTopSensor.get();
    boolean intakeOpen = m_feeder.getIntakeSensor.get();
    boolean intaking = m_oi.getIntake.get();

    if (bottomOpen == false) { // if balls in bottom
      if (topOpen) { // if top is clear
        feederPower = 0.5; // move tower and feeder
        if (intaking == false) { // if not feeding
          feeder2Power = 0.6;
          feeder3Power = 0.4;
        }
      } else { // if top is not clear
        feederPower = 0; // do nothing
      }
    } else { // if bottom is clear
      feederPower = 0; // backfeed incompatible with new sensor location
      /*if (topOpen == false) { // if ball in top
        feederPower = -0.4; // reverse the tower
      } else {
        feederPower = 0; // do nothing
      }*/
    }

    if (intaking) { // if intaking 
      feeder2Power = 0.65; // spin wheels
      feeder3Power = 0.4;
    } else if ((bottomOpen) || (topOpen == false)){
      feeder2Power = 0;
      feeder3Power = 0;
    }

    /*if (topOpen == false) { // if none of top code block, stop inner wheels
      feeder2Power = 0.6; // stop only inner wheels
    }*/

    if ((intakeOpen == false) && (bottomOpen == false) && (topOpen == false)) { //if everything is full
      feeder3Power = 0; // stop outer wheels
    }

    if (m_oi.getBackFeed.get()) {
      feederPower = -0.3;
      feeder2Power = -0.6;
      feeder3Power = -0.6;
    }

    m_feeder.setFeederSpeed(feederPower);
    m_feeder.setFeeder2Speed(feeder2Power);
    m_feeder.setFeeder3Speed(feeder3Power);
  }

  @Override
  public void end(boolean interrupted) {
    m_feeder.setFeederSpeed(0);
    m_feeder.setFeeder2Speed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}