package frc.robot.commands.auto.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.commands.LightOn;
import frc.robot.commands.auto.DriveTimed;
import frc.robot.commands.drive.Brake;
import frc.robot.commands.drive.Coast;
import frc.robot.commands.shooter.Shoot;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class TowerSimple extends SequentialCommandGroup {
	@SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
	public TowerSimple(double startDelay, Shooter shooter, Feeder feeder, Limelight limelight, Drive drive) {
		addCommands(
			new Brake(drive),
			new WaitCommand(startDelay), 
			new LightOn(limelight), 
			new WaitCommand(0.5),
			new Shoot(-1, shooter, feeder, limelight),
			new DriveTimed(drive, 1, 0.4),
			new WaitCommand(1),
			new Coast(drive));
			//new SetDistance(1000, drive));
	}
}