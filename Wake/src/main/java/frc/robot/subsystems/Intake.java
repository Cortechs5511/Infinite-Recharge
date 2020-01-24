package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    public VictorSPX wrist = new VictorSPX(30);
    public VictorSPX intake = new VictorSPX(31);

    public Encoder encoder = new Encoder(0, 1);
    
public Intake() {
    wrist.configFactoryDefault();
    intake.configFactoryDefault();
   
    wrist.setNeutralMode(NeutralMode.Coast);
    intake.setNeutralMode(NeutralMode.Brake);

    intake.configOpenloopRamp(0.5);
  } 

  @Override
  public void periodic() {
  }
}