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
    SmartDashboard.putNumber("P", 0.00005);
    SmartDashboard.putNumber("I", 0.000001);
    SmartDashboard.putNumber("D", 0);
    SmartDashboard.putNumber("FF", 0.000156);
    SmartDashboard.putNumber("Target Distance", 0);
    m_drive.NEOPID.setOutputRange(-0.9, 0.9);
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("NEO Speed Left", m_drive.leftenc.getPosition());
    SmartDashboard.putNumber("NEO Speed Right", m_drive.rightenc.getPosition());

    kP = SmartDashboard.getNumber("P", 0.00005);
    kI = SmartDashboard.getNumber("I", 0.000001);
    kD = SmartDashboard.getNumber("D", 0);
    kFF = SmartDashboard.getNumber("FF", 0.000156);

    targetDistance = SmartDashboard.getNumber("Target Distance", 0);

    m_drive.NEOPID.setP(kP);
    m_drive.NEOPID.setI(kI);
    m_drive.NEOPID.setD(kD);
    m_drive.NEOPID.setFF(kFF);

    m_drive.NEOPID.setReference(targetDistance, ControlType.kPosition);
    m_drive.left1.set(m_drive.left0.get());
    m_drive.right1.set(m_drive.right0.get());
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