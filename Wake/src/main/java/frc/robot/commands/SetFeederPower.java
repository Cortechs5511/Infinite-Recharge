package frc.robot.commands;

import frc.robot.subsystems.Feeder;
import frc.robot.OI;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetFeederPower extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Feeder m_feeder;
  private OI m_oi = OI.getInstance();

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
    if (m_feeder.getBottomSensor.get() == false) { // if balls in bottom
      if (m_feeder.getTopSensor.get()) { // if top is clear
        m_feeder.setFeederSpeed(0.4); // move tower and feeder
        m_feeder.setFeeder2Speed(0.4);
      } else { // if top is not clear
        if (m_oi.getIntake.get()) { // if intaking
          m_feeder.setFeeder2Speed(0.6); // move black balls, not tower
          m_feeder.setFeederSpeed(0);
        } else {
          m_feeder.setFeeder2Speed(0); // do nothing
          m_feeder.setFeederSpeed(0);
        }
      }
    } else { // if bottom is clear
      if ((m_feeder.getTopSensor.get() == false) || (m_oi.getBackFeed.get())) { // if ball in top
        m_feeder.setFeederSpeed(-0.4); // reverse the tower
      } else {
        m_feeder.setFeederSpeed(0); // do nothing
        m_feeder.setFeeder2Speed(0);
      }
    }
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