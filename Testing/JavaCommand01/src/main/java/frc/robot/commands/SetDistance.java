/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Drive;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class SetDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive m_subsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SetDistance(Drive subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
  private double kP, kI, kD, kFF, targetDistanceL, targetDistanceR;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("P", 0.0002);
    SmartDashboard.putNumber("I", 0);
    SmartDashboard.putNumber("D", 0.002);
    SmartDashboard.putNumber("FF", 0.00022);
    SmartDashboard.putNumber("Target DistanceL", 0);
    SmartDashboard.putNumber("Target DistanceR", 0);
    m_subsystem.leftNEOPID.setOutputRange(-0.9, 0.9);
    m_subsystem.rightNEOPID.setOutputRange(-0.9, 0.9);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.left.set(m_subsystem.leftStick.getY());
    m_subsystem.right.set(m_subsystem.rightStick.getY());
    SmartDashboard.putNumber("NEO Speed Left", m_subsystem.leftenc.getPosition());
    SmartDashboard.putNumber("NEO Speed Right", m_subsystem.rightenc.getPosition());

    kP = SmartDashboard.getNumber("P", kP);
    kI = SmartDashboard.getNumber("I", kI);
    kD = SmartDashboard.getNumber("D", kD);
    kFF = SmartDashboard.getNumber("FF", kFF);
    targetDistanceL = SmartDashboard.getNumber("Target DistanceL", targetDistanceL);
    targetDistanceR = SmartDashboard.getNumber("Target DistanceR", targetDistanceR);

    m_subsystem.leftNEOPID.setP(kP);
    m_subsystem.leftNEOPID.setI(kI);
    m_subsystem.leftNEOPID.setD(kD);
    m_subsystem.leftNEOPID.setFF(kFF);

    m_subsystem.rightNEOPID.setP(kP);
    m_subsystem.rightNEOPID.setI(kI);
    m_subsystem.rightNEOPID.setD(kD);
    m_subsystem.rightNEOPID.setFF(kFF);

    m_subsystem.leftNEOPID.setReference(targetDistanceL, ControlType.kPosition);
    m_subsystem.rightNEOPID.setReference(targetDistanceR, ControlType.kPosition);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
