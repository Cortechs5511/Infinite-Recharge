package frc.robot.commands.shooter;

//import frc.robot.commands.drive.LimelightAlign;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ShootAlignNew extends SequentialCommandGroup {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  public ShootAlignNew(Drive drive, Shooter shooter, Feeder feeder, Limelight limelight) {
    addCommands(new AccelLimelight(shooter, limelight, drive), new Cruise(shooter, feeder));
  }
}