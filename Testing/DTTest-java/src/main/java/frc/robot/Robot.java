package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  private CANSparkMax m_frontLeft;
  private CANSparkMax m_frontRight;
  private CANSparkMax m_rearLeft;
  private CANSparkMax m_rearRight;

  private SpeedControllerGroup m_left;
  private SpeedControllerGroup m_right;

  private Joystick m_leftStick;
  private Joystick m_rightStick;

  private double m_leftInput;
  private double m_rightInput;

  @Override
  public void robotInit() {
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
   
    m_frontLeft = new CANSparkMax(10, MotorType.kBrushless);
    m_rearLeft = new CANSparkMax(11, MotorType.kBrushless);
    m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

    m_frontRight = new CANSparkMax(20, MotorType.kBrushless);
    m_rearRight = new CANSparkMax(21, MotorType.kBrushless);
    m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

    m_frontLeft.setOpenLoopRampRate(0.5);
    m_rearLeft.setOpenLoopRampRate(0.5);
    m_frontRight.setOpenLoopRampRate(0.5);
    m_rearRight.setOpenLoopRampRate(0.5);
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    m_leftInput = m_leftStick.getY();
    m_rightInput = m_rightStick.getY();
    m_left.set(m_leftInput);
    m_right.set(m_rightInput);
  }
}