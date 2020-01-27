package frc.robot.commands.shooter;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Accel extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Shooter m_Shooter;
  private Limelight m_Limelight;
  private double currentSpeed, calculatedRPM;
  private int count = 0;

  public Accel(Shooter shooter, Limelight limelight) {
    m_Shooter = shooter;
    m_Limelight = limelight;
    addRequirements(shooter);
    addRequirements(limelight);
  }

  @Override
  public void initialize() {
    m_Shooter.setRampRate(1.5);
    
    calculatedRPM = m_Limelight.calculateRPM();
  }
  
  @Override
  public void execute() {
    m_Shooter.setPIDReference(calculatedRPM);

    currentSpeed = m_Shooter.getSpeed.get();
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.setRampRate(0.15);
  }

  @Override
  public boolean isFinished() {
    if (Math.abs(calculatedRPM - currentSpeed) < 100) {
      count++;
    }
    else {
      count = 0;
    }

    if (count > 25) {
      m_Shooter.targetReached = true;
      return true;
    }
    else {
      return false;
    }
  }
}