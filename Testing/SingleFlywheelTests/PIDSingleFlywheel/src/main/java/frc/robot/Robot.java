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

  private CANPIDController leftNEOPID = m_left.getPIDController();
  private CANPIDController rightNEOPID = m_right.getPIDController();

  private CANEncoder m_leftEncoder = m_left.getEncoder();
  private CANEncoder m_rightEncoder = m_right.getEncoder();

  public double kP, kI, kD, kIz, kFF, targetSpeed;

  @Override
  public void robotInit() {
    m_left.setInverted(false);
    m_right.setInverted(true);

    m_left.setIdleMode(IdleMode.kCoast);
    m_right.setIdleMode(IdleMode.kCoast);

    m_left.setClosedLoopRampRate(1.5);
    m_right.setClosedLoopRampRate(1.5);

    SmartDashboard.putNumber("P", 0.0002);
    SmartDashboard.putNumber("I", 0);
    SmartDashboard.putNumber("D", 0.002);
    SmartDashboard.putNumber("FF", 0.00022);
    SmartDashboard.putNumber("Target Speed", 0);

    leftNEOPID.setP(0.0002);
    leftNEOPID.setI(0);
    leftNEOPID.setD(0.002);
    leftNEOPID.setFF(0.00022);

    rightNEOPID.setP(0.0002);
    rightNEOPID.setI(0);
    rightNEOPID.setD(0.002);
    rightNEOPID.setFF(0.00022);
  }

  @Override
  public void teleopInit() {
    SmartDashboard.putNumber("Target Speed", 0);
  }
  @Override
  public void teleopPeriodic() {
    kP = SmartDashboard.getNumber("P", 0.0002);
    kI = SmartDashboard.getNumber("I", 0);
    kD = SmartDashboard.getNumber("D", 0.002);
    kFF = SmartDashboard.getNumber("FF", 0.00022);
    targetSpeed = SmartDashboard.getNumber("Target Speed", 0);

    leftNEOPID.setP(kP);
    leftNEOPID.setI(kI);
    leftNEOPID.setD(kD);
    leftNEOPID.setFF(kFF);

    rightNEOPID.setP(kP);
    rightNEOPID.setI(kI);
    rightNEOPID.setD(kD);
    rightNEOPID.setFF(kFF);

    leftNEOPID.setReference(targetSpeed, ControlType.kVelocity);
    rightNEOPID.setReference(targetSpeed, ControlType.kVelocity);
    
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Current Speed L", m_leftEncoder.getVelocity());
    SmartDashboard.putNumber("Current Speed R", m_rightEncoder.getVelocity());

    SmartDashboard.putNumber("Left Temperature", m_left.getMotorTemperature());
    SmartDashboard.putNumber("Right Temperature", m_right.getMotorTemperature());    
  }
}