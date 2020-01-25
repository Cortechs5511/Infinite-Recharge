package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase {
  private TalonSRX wrist = new TalonSRX(30);

  public WPI_VictorSPX intake = new WPI_VictorSPX(31);

  /* feeder0 and feeder1 are on the tower */
  private WPI_VictorSPX feeder0 = new WPI_VictorSPX(40);
  private WPI_VictorSPX feeder1 = new WPI_VictorSPX(41);
  private WPI_VictorSPX feeder2 = new WPI_VictorSPX(42);
  private SpeedControllerGroup feeder = new SpeedControllerGroup(feeder0, feeder1);

  private Encoder intakeEncoder = new Encoder(0, 1);

  public DigitalInput bottomSensor = new DigitalInput(0);
  public DigitalInput topSensor = new DigitalInput(1);



  private Encoder feedEncoder = new Encoder(2,3);

  public Intake() {
    wrist.configFactoryDefault();
    intake.configFactoryDefault();
    feeder0.configFactoryDefault();
    feeder1.configFactoryDefault();
    feeder2.configFactoryDefault();

    wrist.setNeutralMode(NeutralMode.Coast);
    intake.setNeutralMode(NeutralMode.Brake);
    feeder0.setNeutralMode(NeutralMode.Brake);
    feeder1.setNeutralMode(NeutralMode.Brake);
    feeder2.setNeutralMode(NeutralMode.Brake);

    feeder0.setInverted(true);
    feeder1.setInverted(false);

    wrist.config_kP(0, 0);
    wrist.config_kI(0, 0);
    wrist.config_kD(0, 0);
    wrist.config_kF(0, 0);

    intake.configOpenloopRamp(0.5);
  }

  @Override
  public void periodic() {
    /* write swtich values to SD */
  }

  public void pullBallIn() {
    intake.set(ControlMode.PercentOutput, 0.9);
  }

  public void stopBall() {
    intake.set(ControlMode.PercentOutput,0.0);
  }

  public void moveWrist(double x) {
    wrist.set(ControlMode.PercentOutput,x);
  }

  public void moveFeederIn() {
    feedEncoder.reset();
    /* needs to be updated with actual value */
    /* to do - figure out switch integration as error checking */
    int x = 0;
    while (feedEncoder.get() < x) {
      feeder.set(0.9);
    }
    feeder.set(0);
  }


}