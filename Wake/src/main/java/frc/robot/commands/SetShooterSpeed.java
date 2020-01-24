package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.OI;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetShooterSpeed extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private Shooter m_Shooter;
  private double targetSpeed, currentSpeed, difference;

  public SetShooterSpeed(Shooter subsystem) {
    m_Shooter = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    m_Shooter.shoot0.setClosedLoopRampRate(1.5);
    m_Shooter.shoot1.setClosedLoopRampRate(1.5);
  }

  @Override
  public void execute() {
    if (m_oi.getShooterLong()) {
      targetSpeed = 4200;
    }
    else if (m_oi.getShooterShort()) {
      targetSpeed = 3300;
    }
    else {
      targetSpeed = 0;
    }
    
    currentSpeed = m_Shooter.shootenc.getVelocity();
    difference = Math.abs(targetSpeed - currentSpeed);

    m_Shooter.shootPID.setReference(targetSpeed, ControlType.kVelocity);
    m_Shooter.shoot1.set(m_Shooter.shoot0.get());
    
    if (difference < 100) {
      m_Shooter.shoot0.setClosedLoopRampRate(0.15);
      m_Shooter.shoot1.setClosedLoopRampRate(0.15);  
    } else if (difference > 1200) {
      m_Shooter.shoot0.setClosedLoopRampRate(1.5);
      m_Shooter.shoot1.setClosedLoopRampRate(1.5);  
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.shoot0.stopMotor();
    m_Shooter.shoot1.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}