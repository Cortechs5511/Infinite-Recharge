package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
	private CANSparkMax left0 = new CANSparkMax(10, MotorType.kBrushless);
	private CANSparkMax left1 = new CANSparkMax(11, MotorType.kBrushless);

	private CANSparkMax right0 = new CANSparkMax(20, MotorType.kBrushless);
	private CANSparkMax right1 = new CANSparkMax(21, MotorType.kBrushless);

	private Joystick leftStick = new Joystick(0);
	private Joystick rightStick = new Joystick(1);

	private double leftInput, rightInput;

	@Override
	public void robotInit() {
		left0.restoreFactoryDefaults();
		left1.restoreFactoryDefaults();
		right0.restoreFactoryDefaults();
		right1.restoreFactoryDefaults();

		left0.setSmartCurrentLimit(40, 40, 20000);
		left1.setSmartCurrentLimit(40, 40, 20000);
		right0.setSmartCurrentLimit(40, 40, 20000);
		right1.setSmartCurrentLimit(40, 40, 20000);

		left0.enableVoltageCompensation(10);
		left1.enableVoltageCompensation(10);
		right0.enableVoltageCompensation(10);
		right1.enableVoltageCompensation(10);

		left0.setIdleMode(IdleMode.kBrake);
		left1.setIdleMode(IdleMode.kBrake);
		right0.setIdleMode(IdleMode.kBrake);
		right1.setIdleMode(IdleMode.kBrake);

		left0.setInverted(false);
		left1.setInverted(false);
		right0.setInverted(true);
		right1.setInverted(true);

		left1.follow(left0);
		right1.follow(right0);
	}

	@Override
	public void teleopInit() {
		left0.set(0);
		right0.set(0);
	}

	@Override
	public void teleopPeriodic() {
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
	}
}