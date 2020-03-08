package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.OI;
import frc.robot.subsystems.Drive;
import frc.robot.Constants.FeederConstants;

public class Intake extends SubsystemBase {
	private TalonSRX wrist = new TalonSRX(FeederConstants.kWristPort);
	private WPI_VictorSPX intake = new WPI_VictorSPX(FeederConstants.kIntakePort);

	private OI m_oi = OI.getInstance();
	private Drive m_drive;

	private double wristInput;

	public Intake(Drive drive) {
		m_drive = drive;

		wrist.configFactoryDefault();
		intake.configFactoryDefault();

		wrist.setNeutralMode(NeutralMode.Brake);
		intake.setNeutralMode(NeutralMode.Brake);

		intake.configOpenloopRamp(0.5);
	}

	@Override
	public void periodic() {
		if (m_oi.getWristDown.get()) {
			wristInput = 0.3;
		} else if (m_oi.getWristUp.get()) {
			wristInput = -0.48;
		} else {
			wristInput = 0;
		}

		if (m_oi.getIntake.get()) {
			intake.set(0.55);
		} else if (m_oi.getIntakeBackFeed.get()) {
			intake.set(-0.6);
		} else {
			if ((Math.abs(m_drive.getLeftVelocity.get()) + Math.abs(m_drive.getRightVelocity.get())) > 270) { // if aveage velocity > 135RPM
				intake.set(-0.3); // sweep intake
			} else { // when close to stopped
				intake.set(0); // stop intake
			}
		}

		wrist.set(ControlMode.PercentOutput, wristInput);
	}
}