package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class StopShooter extends CommandBase {
  private Shooter m_shooter;
  private Feeder m_feeder;
  private Drive m_drive;
  private Limelight m_limelight;
  private OI m_oi = OI.getInstance();

  private int count = 0;

  public StopShooter(Shooter shooter, Limelight limelight, Feeder feeder, Drive drive) {
    addRequirements(shooter);
    addRequirements(limelight);
    addRequirements(feeder);
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    m_feeder.setFeederSpeed(0);
    m_feeder.setFeeder2Speed(0);
    m_feeder.setFeeder3Speed(0);

    m_shooter.setRampRate(1);
    
    m_drive.setLeft(0);
    m_drive.setRight(0);

    m_oi.setLeftRumble(1); // rumble to 1 to try to prevent stuck motor input
    m_oi.setRightRumble(1);

    m_limelight.setLightStatus(1);
  }

  @Override
  public void execute() {
    count++;
  }

  @Override
  public void end(boolean interrupted) {
    m_shooter.setPIDReference(0);
    
    m_oi.setLeftRumble(0);
    m_oi.setRightRumble(0);
  }

  @Override
  public boolean isFinished() {
    return (count > 25); // 0.5 second pause to avoid balls getting stuck in shooter
  }
}
