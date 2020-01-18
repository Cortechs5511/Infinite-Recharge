package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
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

  public CANEncoder leftenc = left0.getEncoder();
  public CANEncoder rightenc = right0.getEncoder();

  public Drive() {
    leftenc.setPositionConversionFactor(42);
    rightenc.setPositionConversionFactor(42);

    left0.clearFaults();
    left1.clearFaults();
    right0.clearFaults();
    right1.clearFaults();
    
    left0.setIdleMode(IdleMode.kCoast);
    left1.setIdleMode(IdleMode.kCoast);
    right0.setIdleMode(IdleMode.kCoast);
    right1.setIdleMode(IdleMode.kCoast);
    
    left0.setInverted(true);
    left1.setInverted(true);
    right0.setInverted(false);
    right1.setInverted(false);

    left0.setSmartCurrentLimit(60, 60, 9000);
    left1.setSmartCurrentLimit(60, 60, 9000);
    right0.setSmartCurrentLimit(60, 60, 9000);
    right1.setSmartCurrentLimit(60, 60, 9000);
  }

  @Override
  public void periodic() {
  }
}