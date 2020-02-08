package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Feeder extends SubsystemBase {
  private WPI_VictorSPX feeder0 = new WPI_VictorSPX(40); //feeder 0 and 1 are tower
  private WPI_VictorSPX feeder1 = new WPI_VictorSPX(41);
  private WPI_VictorSPX feeder2 = new WPI_VictorSPX(42); //feeder 2 is black wheels

  private Encoder intakeEncoder = new Encoder(0, 1); //black wheels
  private Encoder feedEncoder = new Encoder(2, 3); //tower

  private DigitalInput bottomSensor = new DigitalInput(4);
  private DigitalInput topSensor = new DigitalInput(5);
  
  public Supplier<Boolean> getBottomSensor = () -> bottomSensor.get();
  public Supplier<Boolean> getTopSensor = () -> topSensor.get();

  public Supplier<Integer> getIntakeEncoder = () -> intakeEncoder.get();
  public Supplier<Integer> getFeedEncoder = () -> feedEncoder.get();

  public Feeder() {
    feeder0.configFactoryDefault();
    feeder1.configFactoryDefault();
    feeder2.configFactoryDefault();

    feeder0.setNeutralMode(NeutralMode.Brake); 
    feeder1.setNeutralMode(NeutralMode.Brake);
    feeder2.setNeutralMode(NeutralMode.Brake); 

    feeder0.setInverted(true);
    feeder1.setInverted(false);
    feeder2.setInverted(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Top Sensor", getTopSensor.get());
    SmartDashboard.putBoolean("Bottom Sensor", getBottomSensor.get());
    
    SmartDashboard.putNumber("Black Wheels Encoder", intakeEncoder.get()); //intakeEncoder in feeder subsystem = black wheels
    SmartDashboard.putNumber("Tower Encoder", feedEncoder.get());
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