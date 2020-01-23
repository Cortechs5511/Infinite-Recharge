package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

public class Robot extends TimedRobot {
  Joystick leftStick = new Joystick(0);
  Joystick rightStick = new Joystick(1);

  Supplier<Double> gyroAngleRadians;

  NetworkTableEntry autoSpeedEntry = NetworkTableInstance.getDefault().getEntry("/robot/autospeed");
  NetworkTableEntry telemetryEntry = NetworkTableInstance.getDefault().getEntry("/robot/telemetry");
  NetworkTableEntry rotateEntry = NetworkTableInstance.getDefault().getEntry("/robot/rotate");

  double priorAutospeed = 0;
  Number[] numberArray = new Number[10];

  CANSparkMax left0 = new CANSparkMax(10, MotorType.kBrushless);
  CANSparkMax left1 = new CANSparkMax(11, MotorType.kBrushless);

  CANSparkMax right0 = new CANSparkMax(20, MotorType.kBrushless);
  CANSparkMax right1 = new CANSparkMax(21, MotorType.kBrushless);
  
  SpeedControllerGroup leftGroup = new SpeedControllerGroup(left0, left1);
  SpeedControllerGroup rightGroup = new SpeedControllerGroup(right0, right1);

  DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

  private CANEncoder leftEncoder = left0.getEncoder();
  private CANEncoder rightEncoder = right0.getEncoder();

  Supplier<Double> leftEncoderPosition;
  Supplier<Double> leftEncoderSpeed;
  Supplier<Double> rightEncoderPosition;
  Supplier<Double> rightEncoderSpeed;

  @Override
  public void robotInit() {
    if (!isReal()) SmartDashboard.putData(new SimEnabler());

    gyroAngleRadians = () -> 0.0;

    double encoderConstant = (1 / 8.2) * 6 * Math.PI;

    leftEncoderPosition = ()
        -> leftEncoder.getPosition() * encoderConstant;
    leftEncoderSpeed = ()
        -> leftEncoder.getVelocity() * encoderConstant / 60.;

    rightEncoderPosition = ()
        -> rightEncoder.getPosition() * encoderConstant;
    rightEncoderSpeed = ()
        -> rightEncoder.getVelocity() * encoderConstant / 60.;

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

    NetworkTableInstance.getDefault().setUpdateRate(0.010);
  }

  @Override
  public void disabledInit() {
    System.out.println("Robot disabled");
    drive.tankDrive(0, 0);
  }

  @Override
    public void disabledPeriodic() {
  }

  @Override
  public void robotPeriodic() {
    // feedback for users, but not used by the control program
    SmartDashboard.putNumber("Left Position", leftEncoderPosition.get());
    SmartDashboard.putNumber("Left Speed", leftEncoderSpeed.get());
    SmartDashboard.putNumber("Right Position", rightEncoderPosition.get());
    SmartDashboard.putNumber("Right Speed", rightEncoderSpeed.get());
  }

  @Override
  public void teleopInit() {
    System.out.println("Robot in operator control mode");
  }

  @Override
  public void teleopPeriodic() {
    drive.tankDrive(leftStick.getY(), -rightStick.getY());
  }

  @Override
  public void autonomousInit() {
    System.out.println("Robot in autonomous mode");
  }
  @Override
  public void autonomousPeriodic() {
    double now = Timer.getFPGATimestamp();

    double leftPosition = leftEncoder.getPosition();
    double leftRate = leftEncoder.getVelocity();

    double rightPosition = rightEncoder.getPosition();
    double rightRate = rightEncoder.getVelocity();

    double battery = RobotController.getBatteryVoltage();
    double motorVolts = battery * Math.abs(priorAutospeed);

    double leftMotorVolts = motorVolts;
    double rightMotorVolts = motorVolts;

    double autospeed = autoSpeedEntry.getDouble(0);
    priorAutospeed = autospeed;

    drive.tankDrive(
      -(rotateEntry.getBoolean(false) ? -1 : 1) * autospeed, -autospeed,
      false
    );

    numberArray[0] = now;
    numberArray[1] = battery;
    numberArray[2] = autospeed;
    numberArray[3] = leftMotorVolts;
    numberArray[4] = rightMotorVolts;
    numberArray[5] = leftPosition;
    numberArray[6] = rightPosition;
    numberArray[7] = leftRate;
    numberArray[8] = rightRate;
    numberArray[9] = gyroAngleRadians.get();

    telemetryEntry.setNumberArray(numberArray);
  }
}