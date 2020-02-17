package frc.robot.commands.auto;

import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnAngle extends CommandBase {
    private Drive m_drive;
    // to be tuned
    static double kP = 0.03;
    static double kI = 0.00;
    static double kD = 0.0;
    // can be changed to the angle you want
    static final double kTargetAngleDegrees = 90.0f;
    
    public TurnAngle(Drive drive) {
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        SmartDashboard.putNumber("Angle P", 0.02);
        SmartDashboard.putNumber("Angle I", 0.01);
        SmartDashboard.putNumber("Angle D", 0.001);
    }

    @Override
    public void execute() {
        double angle_kP = SmartDashboard.getNumber("Angle P", 0.02);
        double angle_kI = SmartDashboard.getNumber("Angle I", 0.01);
        double angle_kD = SmartDashboard.getNumber("Angle D", 0.001);
        m_drive.anglePID.setPID(angle_kP, angle_kI, angle_kD);
        m_drive.anglePID.setSetpoint(kTargetAngleDegrees);
        double navxAngle = m_drive.getGyroAngle.get();
        double val = m_drive.anglePID.calculate(navxAngle, kTargetAngleDegrees);
        if (Math.abs(val) < 0.05) {
            val = 0;
        } else if (Math.abs(val) > 0.8) {
            val = (0.8 * val / Math.abs(val));
        }
        m_drive.setLeft(val);
        m_drive.setRight(-val);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}