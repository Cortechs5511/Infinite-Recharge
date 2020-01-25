package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import com.revrobotics.ControlType;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Intake;

public class ShooterStop extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Timer timer = new Timer();
  
  private Shooter m_Shooter;
  private Intake m_Intake; 

  private boolean previous, current;
  private int count = 0;


  public ShooterStop(Shooter shooter, Intake intake) {
    m_Shooter = shooter;
    m_Intake = intake;
    addRequirements(m_Shooter);
    addRequirements(m_Intake);
  }

  @Override
  public void initialize() {
    previous = m_Intake.topSensor.get();
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
      current = m_Intake.topSensor.get();
      if (previous != current) {
        count++;
        timer.reset();
        timer.start();
      }
      if (timer.get() > 3) {
          count += 254;
      }
  }

  @Override
  public void end(boolean interrupted) {
    m_Shooter.shoot0.setClosedLoopRampRate(1.5);
    m_Shooter.shoot1.setClosedLoopRampRate(1.5);

    m_Shooter.shootPID.setReference(0, ControlType.kVelocity);
   
    m_Shooter.shoot0.stopMotor();
    m_Shooter.shoot1.stopMotor();
  }

  @Override
  public boolean isFinished() {
      if (count > 5) {
          return true;
      }
      else {
          return false;
      }
  }
}