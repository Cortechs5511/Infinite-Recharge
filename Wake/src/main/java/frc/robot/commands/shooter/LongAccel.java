package frc.robot.commands.shooter;

import frc.robot.subsystems.Shooter;
import frc.robot.OI;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class LongAccel extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private Shooter m_Shooter;
  private double targetSpeed, currentSpeed;
  private int count = 0;

  public LongAccel(Shooter subsystem) {
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

    m_Shooter.shootPID.setReference(targetSpeed, ControlType.kVelocity);
    m_Shooter.shoot1.set(m_Shooter.shoot0.get());

    currentSpeed = m_Shooter.shootEnc.getVelocity();
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.shoot0.setClosedLoopRampRate(0.15);
    m_Shooter.shoot1.setClosedLoopRampRate(0.15);
  }

  @Override
  public boolean isFinished() {
    if (Math.abs(targetSpeed - currentSpeed) < 100) {
      count++;
    }
    else {
      count = 0;
    }

    if (count > 25) {
      return true;
    }
    else {
      return false;
    }
  }
}