package frc.robot.commands.auto;

import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveFixed extends CommandBase {

    private Drive m_drive;
    private double m_timeout;
    private double m_left;
    private double m_right;
    private double startTime;

    public DriveFixed(Drive drive, double left, double right, double timeout) {
        drive = m_drive;
        addRequirements(drive);
        m_left = left;
        m_right = right;
        m_timeout = timeout;
    }

    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        m_drive.setLeft(m_left);
        m_drive.setRight(m_right);
       
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.setLeft(0);
        m_drive.setLeft(0);
    }

    @Override
    public boolean isFinished() {
        double elapsedTime = Timer.getFPGATimestamp() - startTime;
        
        if (elapsedTime >= m_timeout) {
            return true;
        }
        return false;
    }
}
