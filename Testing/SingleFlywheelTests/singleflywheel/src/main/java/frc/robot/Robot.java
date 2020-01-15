package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

public class Robot extends TimedRobot {
  private CANSparkMax m_left = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax m_right = new CANSparkMax(2, MotorType.kBrushless);

  private CANEncoder m_leftEncoder = m_left.getEncoder();
  private CANEncoder m_rightEncoder = m_right.getEncoder();

  @Override
  public void robotInit() {
    m_left.setInverted(false);
    m_right.setInverted(true);

    m_left.setIdleMode(IdleMode.kCoast);
    m_right.setIdleMode(IdleMode.kCoast);

    m_left.setOpenLoopRampRate(3);
    m_right.setOpenLoopRampRate(3);

    SmartDashboard.putNumber("power", 0);
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double power = SmartDashboard.getNumber("power", 0);
    m_left.set(power);
    m_right.set(power);
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Current Speed L", m_leftEncoder.getVelocity());
    SmartDashboard.putNumber("Current Speed R", -m_rightEncoder.getVelocity());
    
    SmartDashboard.putNumber("Left Temperature", m_left.getMotorTemperature());
    SmartDashboard.putNumber("Right Temperature", m_right.getMotorTemperature());    
    
  }
}