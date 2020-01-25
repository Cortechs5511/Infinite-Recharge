package frc.robot.commands.shooter;

import frc.robot.OI;
import frc.robot.subsystems.*;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Shoot extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  //temporary code before limelight based RPM control
  public Shoot(Shooter shooter, Intake intake) {
    if (m_oi.getShooterLong()== true) {
      addCommands(
        new LongAccel(shooter),
        new ShooterStop(shooter, intake));  
    } 
    else if (m_oi.getShooterShort()== true) {
      addCommands(
        new ShortAccel(shooter),
        new ShooterStop(shooter, intake));
    } 
  }
}