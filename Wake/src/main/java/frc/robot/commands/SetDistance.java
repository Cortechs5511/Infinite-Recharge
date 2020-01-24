package frc.robot.commands;

import frc.robot.subsystems.Drive;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drive m_drive;

  public SetDistance(Drive subsystem) {
    m_drive = subsystem;
    addRequirements(subsystem);
  }
  private double kP, kI, kD, kFF, targetDistance;

  @Override
  public void initialize() {
    SmartDashboard.putNumber("P", 0.001);
    SmartDashboard.putNumber("I", 0);
    SmartDashboard.putNumber("D", 0.1);
    SmartDashboard.putNumber("FF", 0);
    SmartDashboard.putNumber("Target Distance", 0);
    m_drive.NEOPID.setOutputRange(-0.3, 0.3);

    m_drive.leftenc.setPosition(0);
    m_drive.rightenc.setPosition(0);
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("Left Distance", m_drive.leftenc.getPosition());
    SmartDashboard.putNumber("Right Distance", m_drive.rightenc.getPosition());

    kP = SmartDashboard.getNumber("P", 0.001);
    kI = SmartDashboard.getNumber("I", 0);
    kD = SmartDashboard.getNumber("D", 0.1);
    kFF = SmartDashboard.getNumber("FF", 0);

    targetDistance = SmartDashboard.getNumber("Target Distance", 0);

    m_drive.NEOPID.setP(kP);
    m_drive.NEOPID.setI(kI);
    m_drive.NEOPID.setD(kD);
    m_drive.NEOPID.setFF(kFF);

    m_drive.NEOPID.setReference(targetDistance, ControlType.kPosition);
    m_drive.left1.set(m_drive.left0.get());
    m_drive.right0.set(m_drive.left0.get());
    m_drive.right1.set(m_drive.left0.get());

    SmartDashboard.putNumber("PID Command", m_drive.left0.get());
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.left.stopMotor();
    m_drive.right.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
