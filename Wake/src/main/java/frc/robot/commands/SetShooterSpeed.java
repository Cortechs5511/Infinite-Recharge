package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.OI;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetShooterSpeed extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private OI m_oi = OI.getInstance();
  private Shooter m_Shooter;
  private double targetSpeed = 0f;

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
    if (m_oi.getShooter()) {
      targetSpeed = 4200;
    }
    else {
      targetSpeed = 0;
    }
    
    m_Shooter.shootPID.setReference(targetSpeed, ControlType.kVelocity);
    m_Shooter.shoot1.set(m_Shooter.shoot0.get());
    /* This needs a system to decrease ramp speed once target has reached.
    In testing, we saw that the current ramp rate of 1.5 sec. was too little
    for the PID to effectively compensate for the RPM. */
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