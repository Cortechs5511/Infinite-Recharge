package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class ResetEncoders extends CommandBase {

	private Drive m_drive;

    public ResetEncoders(Drive drive) {
		m_drive = drive;
		
		addRequirements(m_drive);
	}

	@Override
	public void initialize() {
        m_drive.resetRightEnc();
		m_drive.resetLeftEnc();
		m_drive.zeroHeading();
	}

	@Override
	public void execute() {
	}

	@Override
	public boolean isFinished() {
        return true;
	}

	@Override
	public void end(boolean interrupted) {
		 
	}
}