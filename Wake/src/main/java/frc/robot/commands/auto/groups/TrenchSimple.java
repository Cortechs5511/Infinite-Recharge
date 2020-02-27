package frc.robot.commands.auto.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.commands.LightOn;
import frc.robot.commands.auto.SetDistance;
import frc.robot.commands.auto.TurnAngle;

import frc.robot.commands.shooter.Shoot;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class TrenchSimple extends SequentialCommandGroup {
	@SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
	public TrenchSimple(double startDelay, Shooter shooter, Feeder feeder, Limelight limelight, Drive drive) {
		addCommands(
			new WaitCommand(startDelay), 
			new LightOn(limelight), 
			new WaitCommand(0.5),
			new Shoot(-1, shooter, feeder, limelight),
			new TurnAngle(-20, 0.5, drive),
			new SetDistance(-2, drive));
	}
}