package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    public TalonSRX wrist = new TalonSRX(30);

    public VictorSPX intake = new VictorSPX(31);

    public VictorSPX feeder0 = new VictorSPX(40);
    public VictorSPX feeder1 = new VictorSPX(41);
    public VictorSPX feeder2 = new VictorSPX(42);
    public Encoder intakeEncoder = new Encoder(0, 1);
    
    public DigitalInput switch0 = new DigitalInput(0);
    public DigitalInput switch1 = new DigitalInput(1);

public Intake() {
    wrist.configFactoryDefault();
    intake.configFactoryDefault();
    feeder0.configFactoryDefault();
    feeder1.configFactoryDefault();
    feeder2.configFactoryDefault();
   
    wrist.setNeutralMode(NeutralMode.Coast);
    intake.setNeutralMode(NeutralMode.Brake);

    wrist.config_kP(0, 0);
    wrist.config_kI(0, 0);
    wrist.config_kD(0, 0);
    wrist.config_kF(0, 0);

    intake.configOpenloopRamp(0.5);
  } 

  @Override
  public void periodic() {
  }
}