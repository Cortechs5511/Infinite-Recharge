package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  private CANSparkMax left0 = new CANSparkMax(10, MotorType.kBrushless);
  private CANSparkMax left1 = new CANSparkMax(11, MotorType.kBrushless);

  private CANSparkMax right0 = new CANSparkMax(20, MotorType.kBrushless);
  private CANSparkMax right1 = new CANSparkMax(21, MotorType.kBrushless);

  private CANEncoder leftEnc = left0.getEncoder();
  private CANEncoder rightEnc = right0.getEncoder();

  private CANSparkMax shoot0 = new CANSparkMax(50, MotorType.kBrushless);
  private CANSparkMax shoot1 = new CANSparkMax(51, MotorType.kBrushless);

  private WPI_VictorSPX feeder0 = new WPI_VictorSPX(40); // feeder 0 and 1 are tower
  private WPI_VictorSPX feeder1 = new WPI_VictorSPX(41);
  private WPI_VictorSPX feeder2 = new WPI_VictorSPX(42);

  private TalonSRX wrist = new TalonSRX(30);
  private WPI_VictorSPX intake = new WPI_VictorSPX(31);

  private CANPIDController shootPID = shoot0.getPIDController();
  private CANEncoder shootEnc = shoot0.getEncoder();

  private Joystick leftStick = new Joystick(0);
  private Joystick rightStick = new Joystick(1);

  private double leftInput, rightInput;
  private double kP, kI, kD, kFF;
  private double intakePower, feedWheelPower, feedTowerPower, wristPowerUp, wristPowerDown;

  @Override
  public void robotInit() {
    left0.clearFaults();
    left1.clearFaults();
    right0.clearFaults();
    right1.clearFaults();

    left0.restoreFactoryDefaults();
    left1.restoreFactoryDefaults();
    right0.restoreFactoryDefaults();
    right1.restoreFactoryDefaults();

    left1.follow(left0);
    right1.follow(right0);

    left0.setIdleMode(IdleMode.kCoast);
    left1.setIdleMode(IdleMode.kCoast);
    right0.setIdleMode(IdleMode.kCoast);
    right1.setIdleMode(IdleMode.kCoast);

    left0.setInverted(false);
    left1.setInverted(false);
    right0.setInverted(true);
    right1.setInverted(true);

    left0.enableVoltageCompensation(9);
    left1.enableVoltageCompensation(9);
    right0.enableVoltageCompensation(9);
    right1.enableVoltageCompensation(9);

    left0.setOpenLoopRampRate(0.5);
    left1.setOpenLoopRampRate(0.5);
    right0.setOpenLoopRampRate(0.5);
    right1.setOpenLoopRampRate(0.5);

    left0.setClosedLoopRampRate(0.5);
    left1.setClosedLoopRampRate(0.5);
    right0.setClosedLoopRampRate(0.5);
    right1.setClosedLoopRampRate(0.5);

    left0.setSmartCurrentLimit(60, 60, 9000);
    left1.setSmartCurrentLimit(60, 60, 9000);
    right0.setSmartCurrentLimit(60, 60, 9000);
    right1.setSmartCurrentLimit(60, 60, 9000);

    leftEnc.setPositionConversionFactor(42);
    rightEnc.setPositionConversionFactor(42);

    feeder0.configFactoryDefault();
    feeder1.configFactoryDefault();
    feeder2.configFactoryDefault();

    feeder0.setNeutralMode(NeutralMode.Brake);
    feeder1.setNeutralMode(NeutralMode.Brake);
    feeder2.setNeutralMode(NeutralMode.Coast);

    feeder0.setInverted(true); // may need to be changed depending on motor config
    feeder1.setInverted(false);
    feeder2.setInverted(true); // test this

    wrist.configFactoryDefault();
    wrist.setInverted(true);
    intake.configFactoryDefault();

    wrist.setNeutralMode(NeutralMode.Coast);
    intake.setNeutralMode(NeutralMode.Brake);

    shoot0.restoreFactoryDefaults();
    shoot1.restoreFactoryDefaults();

    shoot0.setInverted(false); // may need to be changed
    shoot1.setInverted(true);

    shoot0.setIdleMode(IdleMode.kCoast);
    shoot1.setIdleMode(IdleMode.kCoast);

    shoot0.setSecondaryCurrentLimit(250);
    shoot1.setSecondaryCurrentLimit(250);

    shoot0.setSmartCurrentLimit(200, 200, 200000);
    shoot1.setSmartCurrentLimit(200, 200, 200000);

    shoot1.follow(shoot0);

    shootPID.setOutputRange(0, 0.95);

    SmartDashboard.putNumber("Shoot P", 0.00033);
    SmartDashboard.putNumber("Shoot I", 0);
    SmartDashboard.putNumber("Shoot D", 0.003);
    SmartDashboard.putNumber("Shoot FF", 0.0002);

    shootPID.setP(0.00033); // will need to be re-tested on the new shooter
    shootPID.setI(0);
    shootPID.setD(0.003);
    shootPID.setFF(0.0002);

    SmartDashboard.putNumber("Intake Power", 0.5);
    SmartDashboard.putNumber("Feeder 2 Power", 0.5);
    SmartDashboard.putNumber("Feeder Tower Power", 0.5);
    SmartDashboard.putNumber("Wrist Power Up", 0.3);
    SmartDashboard.putNumber("Wrist Power Down", 0.2);

    SmartDashboard.putBoolean("At target: ramp rate decreased", false);

  }

  public void robotPeriodic() {
    SmartDashboard.putNumber("Left Speed", leftEnc.getVelocity());
    SmartDashboard.putNumber("Right Speed", rightEnc.getVelocity());

    SmartDashboard.putNumber("Left Input", left0.get());
    SmartDashboard.putNumber("Right Input", right0.get());

    SmartDashboard.putNumber("Shooter Speed", shootEnc.getVelocity());
    SmartDashboard.putNumber("Shooter Command", shoot0.get());

  }

  @Override
  public void autonomousInit() {
    left0.stopMotor();
    right0.stopMotor();
  }

  @Override
  public void teleopPeriodic() {
    intakePower = SmartDashboard.getNumber("Intake Power", 0.5);
    feedWheelPower = SmartDashboard.getNumber("Feeder 2 Power", 0.5);
    feedTowerPower = SmartDashboard.getNumber("Feeder Tower Power", 0.5);
    wristPowerUp = SmartDashboard.getNumber("Wrist Power Up", 0.3);
    wristPowerDown = SmartDashboard.getNumber("Wrist Power Down", 0.2);

    kP = SmartDashboard.getNumber("Shoot P", 0.00033);
    kI = SmartDashboard.getNumber("Shoot I", 0);
    kD = SmartDashboard.getNumber("Shoot D", 0.003);
    kFF = SmartDashboard.getNumber("Shoot FF", 0.0002);

    shootPID.setP(kP); // will need to be re-tested on the new shooter
    shootPID.setI(kI);
    shootPID.setD(kD);
    shootPID.setFF(kFF);

    leftInput = leftStick.getY();
    rightInput = rightStick.getY();

    if (Math.abs(leftInput) > 0.1) {
      left0.set(leftInput * 0.9);
    } else {
      left0.set(0);
    }
    if (Math.abs(rightInput) > 0.1) {
      right0.set(rightInput * 0.9);
    } else {
      right0.set(0);
    }

    if (leftStick.getRawButton(1)) {
      wrist.set(ControlMode.PercentOutput, wristPowerUp);
    } else if (rightStick.getRawButton(1)) {
      wrist.set(ControlMode.PercentOutput, wristPowerDown);
    } else {
      wrist.set(ControlMode.PercentOutput, 0);
    }

    if (leftStick.getRawButton(2)) {
      feeder0.set(feedTowerPower);
      feeder1.set(feedTowerPower);
    } else {
      feeder0.set(0);
      feeder1.set(0);
    }

    if (rightStick.getRawButton(2)) {
      feeder2.set(feedWheelPower);
    } else {
      feeder2.set(0);
    }

    if (leftStick.getRawButton(3)) {
      intake.set(intakePower);
    } else {
      intake.set(0);
    }
    if (rightStick.getRawButton(3)) {
      shootPID.setReference(4200, ControlType.kVelocity);
    } else {
      shootPID.setReference(0, ControlType.kVelocity);
    }

    if (shootEnc.getVelocity() > 4000) {
      shoot0.setClosedLoopRampRate(0.15);
      shoot1.setClosedLoopRampRate(0.15);
      SmartDashboard.putBoolean("At target: ramp rate decreased", true);
    } else if (shootEnc.getVelocity() < 3000) {
      shoot0.setClosedLoopRampRate(1.5);
      shoot1.setClosedLoopRampRate(1.5);
      SmartDashboard.putBoolean("At target: ramp rate decreased", false);
    }
  }
}
