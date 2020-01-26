package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase {
  private TalonSRX wrist = new TalonSRX(30);

  private WPI_VictorSPX intake = new WPI_VictorSPX(31);

  private WPI_VictorSPX feeder0 = new WPI_VictorSPX(40); //feeder 0 and 1 are tower
  private WPI_VictorSPX feeder1 = new WPI_VictorSPX(41);
  private WPI_VictorSPX feeder2 = new WPI_VictorSPX(42);

  private Encoder intakeEncoder = new Encoder(0, 1);
  private Encoder feedEncoder = new Encoder(2, 3);

  private DigitalInput bottomSensor = new DigitalInput(4);
  private DigitalInput topSensor = new DigitalInput(5);
  
  public Supplier<Boolean> getBottomSensor = () -> bottomSensor.get();
  public Supplier<Boolean> getTopSensor = () -> topSensor.get();

  public Supplier<Integer> getIntakeEncoder = () -> intakeEncoder.get();
  public Supplier<Integer> getFeedEncoder = () -> feedEncoder.get();

  public Intake() {
    wrist.configFactoryDefault();
    intake.configFactoryDefault();
    feeder0.configFactoryDefault();
    feeder1.configFactoryDefault();
    feeder2.configFactoryDefault();

    wrist.setNeutralMode(NeutralMode.Coast);
    intake.setNeutralMode(NeutralMode.Brake);

    feeder0.setNeutralMode(NeutralMode.Brake); //feeder 0 and 1 (tower) are braked
    feeder1.setNeutralMode(NeutralMode.Brake);
    feeder2.setNeutralMode(NeutralMode.Coast); //set of wheels braken't

    feeder0.setInverted(true); //may need to be changed depending on motor config
    feeder1.setInverted(false);

    wrist.config_kP(0, 0);
    wrist.config_kI(0, 0);
    wrist.config_kD(0, 0);
    wrist.config_kF(0, 0);

    intake.configOpenloopRamp(0.5);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Top Sensor", getTopSensor.get());
    SmartDashboard.putBoolean("Bottom Sensor", getBottomSensor.get());
    SmartDashboard.putNumber("Intake Encoder", intakeEncoder.get());
    SmartDashboard.putNumber("Feeder Encoder", feedEncoder.get());

    SmartDashboard.putBoolean("Forward Limit Switch", wrist.isFwdLimitSwitchClosed()==1);
    SmartDashboard.putBoolean("Reverse Limit Switch", wrist.isRevLimitSwitchClosed()==1);   
  }

  public void moveWrist(double input) {
    wrist.set(ControlMode.PercentOutput, input);
  }
  public void setIntakePower(double input) {
    intake.set(input);
  }
  public void setFeederSpeed(double input) {
    feeder0.set(input);
    feeder1.set(input);
  }
  public void setFeeder2Speed(double input) {
    feeder2.set(input);
  }
  public void resetFeedEncoder() {
    feedEncoder.reset();
  }
}