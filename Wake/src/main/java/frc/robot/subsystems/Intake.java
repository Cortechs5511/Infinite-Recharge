package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.OI;

public class Intake extends SubsystemBase {
  private TalonSRX wrist = new TalonSRX(30);
  private WPI_VictorSPX intake = new WPI_VictorSPX(31);

  private OI m_oi = OI.getInstance();
  private double wristInput = 0f;
  
  public Intake() {
    wrist.configFactoryDefault();
    intake.configFactoryDefault();

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
    SmartDashboard.putBoolean("Forward Limit Switch", wrist.isFwdLimitSwitchClosed()==1);
    SmartDashboard.putBoolean("Reverse Limit Switch", wrist.isRevLimitSwitchClosed()==1);   

    if (m_oi.getWristDown.get() == true) {
      wristInput = -0.9;
    } else if (m_oi.getWristUp.get() == true) {
      wristInput = 0.9;
    } else {
      wristInput = 0;
    }
    
    wrist.set(ControlMode.PercentOutput, wristInput);
    }
  public void setIntakePower(double input) {
    intake.set(input);
  }
}