package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.OI;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootLong extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private Shooter m_Shooter;
  private Intake m_Intake;
  private double targetSpeed, currentSpeed;

  public ShootLong(Shooter subsystem) {
    addRequirements(m_Shooter);
    addRequirements(m_Intake);
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
    else {
      targetSpeed = 0;
    }
    
    currentSpeed = m_Shooter.shootEnc.getVelocity();

    m_Shooter.shootPID.setReference(targetSpeed, ControlType.kVelocity);
    m_Shooter.shoot1.set(m_Shooter.shoot0.get());
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.shoot0.stopMotor();
    m_Shooter.shoot1.stopMotor();
  }

  @Override
  public boolean isFinished() {
    if 
  }
}