package frc.robot.commands.auto.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.commands.LightOn;
import frc.robot.commands.auto.SetDistance;
import frc.robot.commands.shooter.Accel;
import frc.robot.commands.shooter.Cruise;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class BackTowerSimple extends SequentialCommandGroup {
	@SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
	public BackTowerSimple(double startDelay, Shooter shooter, Feeder feeder, Limelight limelight, Drive drive) {
		addCommands(
			new WaitCommand(startDelay), 
			new SetDistance(2, drive), 
			new LightOn(limelight),
			new WaitCommand(0.5), 
			new Accel(shooter, limelight), 
			new Cruise(-1, shooter, feeder));
	}
}