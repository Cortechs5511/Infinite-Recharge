package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;

public class Robot extends TimedRobot {
  private CANSparkMax frontLeft;
  private CANSparkMax backLeft;
  private CANSparkMax frontRight;
  private CANSparkMax backRight;

  private Joystick leftStick;
  private Joystick rightStick;

  private double leftStickInput;
  private double rightStickInput;

  private SpeedControllerGroup left;
  private SpeedControllerGroup right;

  @Override
  public void robotInit() {
    leftStick = new Joystick(0);
    rightStick = new Joystick(1);

    // need to add ids not sure what they are right now at the moment
    if (Robot.isReal()) {
      frontRight = new CANSparkMax(20, MotorType.kBrushless);
      backRight = new CANSparkMax(21, MotorType.kBrushless);

      frontLeft = new CANSparkMax(10, MotorType.kBrushless);
      backLeft = new CANSparkMax(11, MotorType.kBrushless);

      right = new SpeedControllerGroup(frontRight, backRight);
      left = new SpeedControllerGroup(frontLeft, backLeft);
    } else {
      // Following is only done in desktop simulation mode so we can try
      // running the code without deploying to the robot
      left = new SpeedControllerGroup(new VictorSP(0), new VictorSP(1));
      right = new SpeedControllerGroup(new VictorSP(3), new VictorSP(4));
    }
  }

  @Override
  public void teleopPeriodic() {
    leftStickInput = leftStick.getY();
    rightStickInput = rightStick.getY();
    left.set(leftStickInput);
    right.set(rightStickInput);
  }

}
