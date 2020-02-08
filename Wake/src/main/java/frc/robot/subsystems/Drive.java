package frc.robot.subsystems;

import java.util.function.Supplier;

import com.revrobotics.CANEncoder;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  private CANSparkMax left0 = new CANSparkMax(10, MotorType.kBrushless);
  private CANSparkMax left1 = new CANSparkMax(11, MotorType.kBrushless);

  private CANSparkMax right0 = new CANSparkMax(20, MotorType.kBrushless);
  private CANSparkMax right1 = new CANSparkMax(21, MotorType.kBrushless);

  private CANPIDController leftNEOPID = left0.getPIDController();
  private CANPIDController rightNEOPID = right0.getPIDController();
  public PIDController anglePID = new PIDController(0.0, 0.0, 0.0);

  private CANEncoder leftEnc = left0.getEncoder();
  private CANEncoder rightEnc = right0.getEncoder();

  private AHRS navx = new AHRS();

  public Supplier<Double> getLeftOutput = () -> left0.get();
  public Supplier<Double> getRightOutput = () -> right0.get();

  public Supplier<Double> getLeftPosition = () -> leftEnc.getPosition();
  public Supplier<Double> getRightPosition = () -> rightEnc.getPosition();

  public Supplier<Double> getLeftVelocity = () -> leftEnc.getVelocity();
  public Supplier<Double> getRightVelocity = () -> rightEnc.getVelocity();

  public Supplier<Double> getGyroAngle = () -> navx.getAngle();

  private double angle_kP, angle_kI, angle_kD;

  public Drive() {
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

    left0.setClosedLoopRampRate(0.5); // still to be tested
    left1.setClosedLoopRampRate(0.5);
    right0.setClosedLoopRampRate(0.5);
    right1.setClosedLoopRampRate(0.5);

    left0.setSmartCurrentLimit(60, 60, 9000);
    left1.setSmartCurrentLimit(60, 60, 9000);
    right0.setSmartCurrentLimit(60, 60, 9000);
    right1.setSmartCurrentLimit(60, 60, 9000);

    leftEnc.setPositionConversionFactor(42);
    rightEnc.setPositionConversionFactor(42);

    leftNEOPID.setP(0.101);
    leftNEOPID.setI(0);
    leftNEOPID.setD(50.3);
    leftNEOPID.setFF(0);
    leftNEOPID.setOutputRange(-0.3, 0.3); // consider changing this during drive testing

    rightNEOPID.setP(0.101);
    rightNEOPID.setI(0);
    rightNEOPID.setD(50.3);
    rightNEOPID.setFF(0);
    leftNEOPID.setOutputRange(-0.3, 0.3);

    anglePID.disableContinuousInput();
    anglePID.setIntegratorRange(-1, 1);

    SmartDashboard.putNumber("Angle P", 0.02);
    SmartDashboard.putNumber("Angle I", 0.01);
    SmartDashboard.putNumber("Angle D", 0.001);
    SmartDashboard.putNumber("Threshold", 1);
  }

  public void setLeft(double leftInput) {
    left0.set(leftInput);
  }

  public void setRight(double rightInput) {
    right0.set(rightInput);
  }

  public void setLeftPIDReference(double ref) {
    leftNEOPID.setReference(ref, ControlType.kPosition);
  }

  public void setRightPIDReference(double ref) {
    rightNEOPID.setReference(ref, ControlType.kPosition);
  }

  public void resetLeftEnc() {
    leftEnc.setPosition(0);
  }

  public void resetRightEnc() {
    rightEnc.setPosition(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Speed", leftEnc.getVelocity());
    SmartDashboard.putNumber("Right Speed", rightEnc.getVelocity());

    SmartDashboard.putNumber("Left Power", left0.get());
    SmartDashboard.putNumber("Right Power", right0.get());

    angle_kP = SmartDashboard.getNumber("Angle P", 0.02);
    angle_kI = SmartDashboard.getNumber("Angle I", 0.01);
    angle_kD = SmartDashboard.getNumber("Angle D", 0.001);
    anglePID.setPID(angle_kP, angle_kI, angle_kD);
  }
}