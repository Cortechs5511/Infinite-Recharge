package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    public CANSparkMax shoot0 = new CANSparkMax(50, MotorType.kBrushless);
    public CANSparkMax shoot1 = new CANSparkMax(51, MotorType.kBrushless);

    public CANPIDController shootPID = shoot0.getPIDController();
    
    public CANEncoder shootEncoder = shoot0.getEncoder();
    
public Shooter() {
    shoot0.restoreFactoryDefaults();
    shoot1.restoreFactoryDefaults();

    shoot0.setInverted(false);
    shoot1.setInverted(true);

    shoot0.setIdleMode(IdleMode.kCoast);
    shoot1.setIdleMode(IdleMode.kCoast);

    shoot0.setSecondaryCurrentLimit(250);
    shoot1.setSecondaryCurrentLimit(250);

    shoot0.setSmartCurrentLimit(200, 200, 200000);
    shoot1.setSmartCurrentLimit(200, 200, 200000);

    shootPID.setOutputRange(0, 0.95);

    shootPID.setP(0.00033);
    shootPID.setI(0);
    shootPID.setD(0.003);
    shootPID.setFF(0.0002);
  } 

  @Override
  public void periodic() {
  }
}