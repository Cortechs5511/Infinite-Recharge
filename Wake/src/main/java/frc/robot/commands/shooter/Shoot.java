package frc.robot.commands.shooter;

import frc.robot.OI;
import frc.robot.subsystems.*;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Shoot extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  //temporary code before limelight based RPM control
  public Shoot(Shooter shooter, Intake intake, Limelight limelight) {
    if (m_oi.getShooter.get()== true) {
      addCommands(
        new Accel(shooter, limelight),
        new Cruise(shooter, intake));  
    } 
  }
}