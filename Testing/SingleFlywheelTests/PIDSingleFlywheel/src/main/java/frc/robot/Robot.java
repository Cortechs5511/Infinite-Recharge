package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  private CANSparkMax m_left = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax m_right = new CANSparkMax(2, MotorType.kBrushless);

  private CANPIDController m_NEOPID = m_left.getPIDController();

  private CANEncoder m_leftEncoder = m_left.getEncoder();
  private CANEncoder m_rightEncoder = m_right.getEncoder();

  private double m_targetSpeed;
  private boolean rampMode = false;

  @Override
  public void robotInit() {
    m_left.setInverted(false);
    m_right.setInverted(true);

    m_left.setIdleMode(IdleMode.kCoast);
    m_right.setIdleMode(IdleMode.kCoast);

    m_NEOPID.setOutputRange(0, 0.95);

    m_left.setClosedLoopRampRate(1.5);
    m_right.setClosedLoopRampRate(1.5);

    m_left.setSmartCurrentLimit(254, 254, 254000);
    
    m_right.setSmartCurrentLimit(254, 254, 254000);

    m_left.setSecondaryCurrentLimit(255);
    m_right.setSecondaryCurrentLimit(255);    

    SmartDashboard.putNumber("P", 0.00033);
    SmartDashboard.putNumber("I", 0);
    SmartDashboard.putNumber("D", 0.003);
    SmartDashboard.putNumber("FF", 0.0002);
    SmartDashboard.putNumber("Target Speed", 0);

    SmartDashboard.putBoolean("Ramp Mode", rampMode);

    m_NEOPID.setP(0.00033);
    m_NEOPID.setI(0);
    m_NEOPID.setD(0.003);
    m_NEOPID.setFF(0.0002);
  }

  @Override
  public void teleopInit() {
    SmartDashboard.putNumber("Target Speed", 0);
  }

  @Override
  public void teleopPeriodic() {
    if (SmartDashboard.getNumber("Target Speed", 0) > 200) {
      m_targetSpeed = SmartDashboard.getNumber("Target Speed", 0);
    }
    else {
      m_targetSpeed = 0;
    }

    m_NEOPID.setP(SmartDashboard.getNumber("P", 0.00033));
    m_NEOPID.setI(SmartDashboard.getNumber("I", 0));
    m_NEOPID.setD(SmartDashboard.getNumber("D", 0.003));
    m_NEOPID.setFF(SmartDashboard.getNumber("FF", 0.0002));

    m_NEOPID.setReference(m_targetSpeed, ControlType.kVelocity);
    m_right.set(m_left.get());
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Current Speed L", m_leftEncoder.getVelocity());
    SmartDashboard.putNumber("Current Speed R", m_rightEncoder.getVelocity());

    rampMode = SmartDashboard.getBoolean("Ramp Mode", false);

    if (rampMode == true) {
      m_left.setClosedLoopRampRate(0.25);
      m_right.setClosedLoopRampRate(0.25);
    }
    else {
      m_left.setClosedLoopRampRate(1.5);
      m_right.setClosedLoopRampRate(1.5);  
    }
    
    SmartDashboard.putNumber("Ramp Speed", m_left.getClosedLoopRampRate());

    SmartDashboard.putNumber("Left Temperature", m_left.getMotorTemperature());
    SmartDashboard.putNumber("Right Temperature", m_right.getMotorTemperature());    

    SmartDashboard.putNumber("Left Input", m_left.get());
    SmartDashboard.putNumber("Right Input", m_right.get());

    SmartDashboard.putNumber("Left Current", m_left.getOutputCurrent());
    SmartDashboard.putNumber("Right Current", m_right.getOutputCurrent());
  }
}