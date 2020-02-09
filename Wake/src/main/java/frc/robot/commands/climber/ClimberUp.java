package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberUp extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private Climber m_climber;

    public ClimberUp(Climber climber) {
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        m_climber.setClimbPower(0.8);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        m_climber.setClimbPower(0);
    }

    @Override
    public boolean isFinished() {
        return (m_climber.getClimbEncoder.get() > 5000); // example figure, change when tuned climber
    }
}