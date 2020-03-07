package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	private CANSparkMax left0 = new CANSparkMax(10, MotorType.kBrushless);
	// private CANSparkMax left1 = new CANSparkMax(11, MotorType.kBrushless);

	// private CANSparkMax right0 = new CANSparkMax(20, MotorType.kBrushless);
	private CANSparkMax right0 = new CANSparkMax(11, MotorType.kBrushless);

	private Joystick leftStick = new Joystick(0);
	private Joystick rightStick = new Joystick(1);

	private double maxPower = 0.2;
	private double power, turn, left, right;

	private boolean arcadeActive = true; 

	@Override
	public void robotInit() {
		left0.clearFaults();
		// left1.clearFaults();
		right0.clearFaults();
		// right1.clearFaults();

		left0.restoreFactoryDefaults();
		// left1.restoreFactoryDefaults();
		right0.restoreFactoryDefaults();
		// right1.restoreFactoryDefaults();

		// left1.follow(left0);
		// right1.follow(right0);

		left0.setIdleMode(IdleMode.kBrake);
		// left1.setIdleMode(IdleMode.kBrake);
		right0.setIdleMode(IdleMode.kBrake);
		// right1.setIdleMode(IdleMode.kBrake);

		left0.setInverted(false);
		// left1.setInverted(false);
		right0.setInverted(true);
		// right1.setInverted(true);

		left0.enableVoltageCompensation(10);
		// left1.enableVoltageCompensation(10);
		right0.enableVoltageCompensation(10);
		// right1.enableVoltageCompensation(10);

		left0.setSmartCurrentLimit(40, 40, 10000);
		// left1.setSmartCurrentLimit(40, 40, 10000);
		right0.setSmartCurrentLimit(40, 40, 10000);
		// right1.setSmartCurrentLimit(40, 40, 10000);

		left0.setOpenLoopRampRate(0.5);
		// left1.setOpenLoopRampRate(0.5);
		right0.setOpenLoopRampRate(0.5);
		// right1.setOpenLoopRampRate(0.5);

		SmartDashboard.putBoolean("Arcade Drive", arcadeActive);
		SmartDashboard.putNumber("Max Power", maxPower);
	}

	@Override
	public void robotPeriodic() {
		SmartDashboard.putNumber("Left Power", left0.get());
		SmartDashboard.putNumber("Right Power", right0.get());

		arcadeActive = SmartDashboard.getBoolean("Arcade Drive", true);
		maxPower = Math.min(0.5, SmartDashboard.getNumber("Max Power", 0.2)); // cap at 0.5
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		if (arcadeActive) {
			power = leftStick.getY() * maxPower; // inputs
			turn = -leftStick.getX() * (maxPower * 1.5);

			if (Math.abs(turn) < 0.1) { // 10% deadband
				turn = 0;
			}
			if (Math.abs(power) < 0.1) {
				power = 0;
			}

			if (power > 0) { // ported over from thor-python
				if (turn > 0) {
					left = Math.max(power, turn);
					right = power - turn;
				} else {
					left = power + turn;
					right = Math.max(power, -turn);
				}
			} else {
				if (turn < 0) {
					left = -(Math.max(-power, -turn));
					right = power - turn;
				} else {
					left = power + turn;
					right = -(Math.max(-power, turn));
				}
			}
		} else {
			left = leftStick.getY() * maxPower;
			right = rightStick.getY() * maxPower;
		}

		left0.set(left);
		right0.set(right);
	}
}
