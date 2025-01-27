package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.subsystems.Climber;
// this command is unused
public class AutoClimb extends SequentialCommandGroup {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  public AutoClimb(Climber climber) {
    // during the wait command, driver should move backward until climber hooks over bar
    addCommands(new ClimberUp(climber), new WaitCommand(3), new ClimberDown(climber));
  }
}