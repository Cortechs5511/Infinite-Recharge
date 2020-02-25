package frc.robot.commands.climber;

import frc.robot.OI;
import frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ManualClimb extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private Climber m_climber;
    private OI m_oi = OI.getInstance();
    private double climberInput;

    public ManualClimb(Climber climber) {
        m_climber = climber;
        addRequirements(climber);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (m_oi.getClimberUp.get()) {
            climberInput = 0.8;
        } else if (m_oi.getClimberDown.get()) {
            climberInput = -0.8;
        } else {
            climberInput = 0;
        }
        m_climber.setClimb0Power(climberInput);
    }

    @Override
    public void end(boolean interrupted) {
        m_climber.setClimb0Power(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
