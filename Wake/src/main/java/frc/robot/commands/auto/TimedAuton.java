package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.shooter.ShootAlign;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class TimedAuton extends SequentialCommandGroup {
    public TimedAuton(Drive drive, Shooter shooter, Feeder feeder, Limelight limelight,double delay, double ShootDelay)
    { 
        addCommands(
            new WaitCommand(ShootDelay),
            new ShootAlign(0.5, -1,drive, shooter, feeder, limelight),
            new WaitCommand(delay),
            new DriveFixed(drive, 0.5,0.5,3)
        );
    }

}
