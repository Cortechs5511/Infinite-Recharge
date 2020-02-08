package frc.robot.subsystems;

import java.util.function.Supplier;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private CANSparkMax shoot0 = new CANSparkMax(50, MotorType.kBrushless);
  private CANSparkMax shoot1 = new CANSparkMax(51, MotorType.kBrushless);

  private CANPIDController shootPID = shoot0.getPIDController();

  private CANEncoder shootEnc = shoot0.getEncoder();

  public Supplier<Double> getSpeed = () -> shootEnc.getVelocity();
  public Boolean targetReached = false;

  public Shooter() {
    shoot0.restoreFactoryDefaults();
    shoot1.restoreFactoryDefaults();

    shoot0.setIdleMode(IdleMode.kCoast);
    shoot1.setIdleMode(IdleMode.kCoast);

    shoot0.setSecondaryCurrentLimit(250);
    shoot1.setSecondaryCurrentLimit(250);

    shoot0.setSmartCurrentLimit(200, 200, 200000);
    shoot1.setSmartCurrentLimit(200, 200, 200000);

    shoot0.setInverted(false); // may need to be changed
    shoot1.setInverted(true);

    shootPID.setOutputRange(0, 0.95);

    shootPID.setP(0.00033); // will need to be re-tested on the new shooter
    shootPID.setI(0);
    shootPID.setD(0.003);
    shootPID.setFF(0.0002);
  }

  public void setSpeed(double input) {
    shoot0.set(input);
    shoot1.set(input);
  }

  public void setRampRate(double rate) {
    shoot0.setClosedLoopRampRate(rate);
    shoot1.setClosedLoopRampRate(rate);
  }

  public void setPIDReference(double ref) {
    shootPID.setReference(ref, ControlType.kVelocity);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Target Reached", targetReached);
    shoot1.set(shoot0.get());
  }
}