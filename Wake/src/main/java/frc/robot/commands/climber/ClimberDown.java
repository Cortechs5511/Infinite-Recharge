package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
// this command is unused
public class ClimberDown extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private Climber m_climber;

    public ClimberDown(Climber climber) {
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_climber.setClimbPower(-0.8);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return (m_climber.getClimbEncoder.get() < 3000); // example figure, change when tuned climber
    }
}