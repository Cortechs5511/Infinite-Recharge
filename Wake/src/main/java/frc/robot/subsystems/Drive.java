package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  public CANSparkMax left0 = new CANSparkMax(10, MotorType.kBrushless);
  public CANSparkMax left1 = new CANSparkMax(11, MotorType.kBrushless);
  public SpeedControllerGroup left = new SpeedControllerGroup(left0, left1);

  public CANSparkMax right0 = new CANSparkMax(20, MotorType.kBrushless);
  public CANSparkMax right1 = new CANSparkMax(21, MotorType.kBrushless);
  public SpeedControllerGroup right = new SpeedControllerGroup(right0, right1);

  public CANPIDController leftNEOPID = left0.getPIDController();
  public CANPIDController rightNEOPID = right0.getPIDController();
  public PIDController anglePID = new PIDController(0.0, 0.0, 0.0);

  public CANEncoder leftEnc = left0.getEncoder();
  public CANEncoder rightEnc = right0.getEncoder();

  public Drive() {
    leftEnc.setPositionConversionFactor(42);
    rightEnc.setPositionConversionFactor(42);

    left0.clearFaults();
    left1.clearFaults();
    right0.clearFaults();
    right1.clearFaults();

    left0.restoreFactoryDefaults();
    left1.restoreFactoryDefaults();
    right0.restoreFactoryDefaults();
    right1.restoreFactoryDefaults();
    
    left0.setIdleMode(IdleMode.kCoast);
    left1.setIdleMode(IdleMode.kCoast);
    right0.setIdleMode(IdleMode.kCoast);
    right1.setIdleMode(IdleMode.kCoast);
    
    left0.setInverted(false);
    left1.setInverted(false);
    right0.setInverted(true);
    right1.setInverted(true);

    left0.disableVoltageCompensation();
    left1.disableVoltageCompensation();
    right0.disableVoltageCompensation();
    right1.disableVoltageCompensation();

    left0.setOpenLoopRampRate(0.5);
    left1.setOpenLoopRampRate(0.5);
    right0.setOpenLoopRampRate(0.5);
    right1.setOpenLoopRampRate(0.5);

    left0.setClosedLoopRampRate(0.5);
    left1.setClosedLoopRampRate(0.5);
    right0.setClosedLoopRampRate(0.5);
    right1.setClosedLoopRampRate(0.5);
    //note to future programmers:
    //if using neo, use ramp rate

    left0.setSmartCurrentLimit(60, 60, 9000);
    left1.setSmartCurrentLimit(60, 60, 9000);
    right0.setSmartCurrentLimit(60, 60, 9000);
    right1.setSmartCurrentLimit(60, 60, 9000);

    leftEnc.setPositionConversionFactor(42);
    rightEnc.setPositionConversionFactor(42);   
   
    leftNEOPID.setP(0.101);
    leftNEOPID.setI(0);
    leftNEOPID.setD(50.3);
    leftNEOPID.setFF(0);
    leftNEOPID.setOutputRange(-0.3, 0.3);

    rightNEOPID.setP(0.101);
    rightNEOPID.setI(0);
    rightNEOPID.setD(50.3);
    rightNEOPID.setFF(0);
    leftNEOPID.setOutputRange(-0.3, 0.3);

    anglePID.setPID(0.0, 0.0, 0.0);
    anglePID.enableContinuousInput(-30, 30);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Speed", leftEnc.getVelocity());
    SmartDashboard.putNumber("Right Speed", rightEnc.getVelocity());
  }
}