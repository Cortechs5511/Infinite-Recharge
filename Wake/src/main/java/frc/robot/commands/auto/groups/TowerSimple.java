package frc.robot.commands.auto.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.commands.auto.SetDistance;
import frc.robot.commands.shooter.Shoot;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class TowerSimple extends SequentialCommandGroup {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  public TowerSimple(double startDelay, Shooter shooter, Feeder feeder, Limelight limelight, Drive drive) {
    addCommands(
      new WaitCommand(startDelay), 
      new Shoot(-1, shooter, feeder, limelight), 
      new SetDistance(-2, drive));
  }
}