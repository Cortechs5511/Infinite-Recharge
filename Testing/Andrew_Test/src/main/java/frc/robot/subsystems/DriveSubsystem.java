
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  public CANSparkMax left_1 = new CANSparkMax(10, MotorType.kBrushless);
  public CANSparkMax left_2 = new CANSparkMax(11, MotorType.kBrushless);
  public SpeedControllerGroup left = new SpeedControllerGroup(left_1, left_2);

  public CANSparkMax right_1 = new CANSparkMax(20, MotorType.kBrushless);
  public CANSparkMax right_2 = new CANSparkMax(21, MotorType.kBrushless);
  public SpeedControllerGroup right = new SpeedControllerGroup(right_1, right_2);

  public CANEncoder left_encoder = left_1.getEncoder();


  public DriveSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
