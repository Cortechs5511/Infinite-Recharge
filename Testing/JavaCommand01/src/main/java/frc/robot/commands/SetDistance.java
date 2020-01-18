package frc.robot.commands;

import frc.robot.subsystems.*;
import frc.robot.OI;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive m_drive;
  private OI m_oi;
  
  public SetDistance(Drive subsystem) {
    m_drive = subsystem;
    addRequirements(subsystem);
  }
  private double kP, kI, kD, kFF, targetDistanceL, targetDistanceR;

  @Override
  public void initialize() {
    SmartDashboard.putNumber("P", 0.00005);
    SmartDashboard.putNumber("I", 0.000001);
    SmartDashboard.putNumber("D", 0);
    SmartDashboard.putNumber("FF", 0.000156);
    SmartDashboard.putNumber("Target DistanceL", 0);
    SmartDashboard.putNumber("Target DistanceR", 0);
    m_drive.leftNEOPID.setOutputRange(-0.9, 0.9);
    m_drive.rightNEOPID.setOutputRange(-0.9, 0.9);
  }

  @Override
  public void execute() {
    m_drive.left.set(m_oi.leftStick.getY());
    m_drive.right.set(m_oi.rightStick.getY());
    SmartDashboard.putNumber("NEO Speed Left", m_drive.leftenc.getPosition());
    SmartDashboard.putNumber("NEO Speed Right", m_drive.rightenc.getPosition());

    kP = SmartDashboard.getNumber("P", 0.00005);
    kI = SmartDashboard.getNumber("I", 0.000001);
    kD = SmartDashboard.getNumber("D", 0);
    kFF = SmartDashboard.getNumber("FF", 0.000156);

    targetDistanceL = SmartDashboard.getNumber("Target DistanceL", targetDistanceL);
    targetDistanceR = SmartDashboard.getNumber("Target DistanceR", targetDistanceR);

    m_drive.leftNEOPID.setP(kP);
    m_drive.leftNEOPID.setI(kI);
    m_drive.leftNEOPID.setD(kD);
    m_drive.leftNEOPID.setFF(kFF);

    m_drive.rightNEOPID.setP(kP);
    m_drive.rightNEOPID.setI(kI);
    m_drive.rightNEOPID.setD(kD);
    m_drive.rightNEOPID.setFF(kFF);

    m_drive.leftNEOPID.setReference(targetDistanceL, ControlType.kPosition);
    m_drive.left1.set(m_drive.left0.get());

    m_drive.rightNEOPID.setReference(targetDistanceR, ControlType.kPosition);
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
