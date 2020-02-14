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
    boolean bottomOpen = m_feeder.getBottomSensor.get();
    boolean topOpen = m_feeder.getTopSensor.get();
    if (bottomOpen == false) { // if balls in bottom
      if (topOpen) { // if top is clear
        m_feeder.setFeederSpeed(0.4); // move tower and feeder
        if (m_oi.getIntake.get() == false) { // if not feeding
          m_feeder.setFeeder2Speed(0.4);
        }
      } else { // if top is not clear
        m_feeder.setFeederSpeed(0); // do nothing
      }
    } else { // if bottom is clear
      if ((topOpen == false) || (m_oi.getBackFeed.get())) { // if ball in top
        m_feeder.setFeederSpeed(-0.4); // reverse the tower
      } else {
        m_feeder.setFeederSpeed(0); // do nothing
      }
    }
    if (m_oi.getIntake.get()) { // if intaking
      m_feeder.setFeeder2Speed(0.6); // move black balls, not tower
    } else if ((bottomOpen) || (topOpen == false)) { // if none of the above, then stop feeder wheels
      m_feeder.setFeeder2Speed(0);
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