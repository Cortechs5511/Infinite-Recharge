package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
  private WPI_VictorSPX feeder0 = new WPI_VictorSPX(40); // feeder 0 and 1 are tower
  private WPI_VictorSPX feeder1 = new WPI_VictorSPX(41);
  private WPI_VictorSPX feeder2 = new WPI_VictorSPX(42); // feeder 2, 3 are feeder wheels
  private WPI_VictorSPX feeder3 = new WPI_VictorSPX(43);

  private DigitalInput bottomSensor = new DigitalInput(0);
  private DigitalInput topSensor = new DigitalInput(1);
  private DigitalInput intakeSensor = new DigitalInput(2);

  private Encoder intakeEncoder = new Encoder(3, 4); // wrist -- inop
  private Encoder feedEncoder = new Encoder(5, 6); // tower -- inop

  public Supplier<Boolean> getBottomSensor = () -> bottomSensor.get();
  public Supplier<Boolean> getTopSensor = () -> topSensor.get();
  public Supplier<Boolean> getIntakeSensor = () -> intakeSensor.get();

  public Supplier<Integer> getIntakeEncoder = () -> intakeEncoder.get();
  public Supplier<Integer> getFeedEncoder = () -> feedEncoder.get();

  public Feeder() {
    feeder0.configFactoryDefault();
    feeder1.configFactoryDefault();
    feeder2.configFactoryDefault();
    feeder2.configFactoryDefault();

    feeder0.setNeutralMode(NeutralMode.Brake);
    feeder1.setNeutralMode(NeutralMode.Brake);
    feeder2.setNeutralMode(NeutralMode.Brake);
    feeder2.setNeutralMode(NeutralMode.Brake);

    feeder0.setInverted(false);
    feeder1.setInverted(true);
    feeder2.setInverted(true);
    feeder3.setInverted(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Top Sensor", topSensor.get());
    SmartDashboard.putBoolean("Bottom Sensor", bottomSensor.get());
    SmartDashboard.putBoolean("Intake Sensor", intakeSensor.get());

    SmartDashboard.putNumber("Feeder Wheels Encoder", intakeEncoder.get()); // intakeEncoder in feeder subsystem = black wheels
    SmartDashboard.putNumber("Tower Encoder", feedEncoder.get());
  }

  public void setFeederSpeed(double input) {
    feeder0.set(input);
    feeder1.set(input);
  }

  public void setFeeder2Speed(double input) {
    feeder2.set(input);
    feeder3.set(input);
  }

  public void resetFeedEncoder() {
    feedEncoder.reset();
  }
}