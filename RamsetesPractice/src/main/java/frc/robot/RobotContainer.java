package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.auto.paths.*;
import frc.robot.commands.drive.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RobotContainer {
	private final Drive m_drive = new Drive();
	private final SetSpeed m_setSpeed = new SetSpeed(m_drive);
	private final StopDrive m_stop = new StopDrive(m_drive);

	Joystick leftStick = new Joystick(0);
	Joystick rightStick = new Joystick(1);
	XboxController controller = new XboxController(2);

	enum autonMode {
		TowerSimple, BackTowerSimple, TrenchSimple, TowerSimpleForward
	}

	SendableChooser<autonMode> m_chooser = new SendableChooser<>();

	public static double getNumber(String key, double defaultValue) {
		if (SmartDashboard.containsKey(key)) {
			return SmartDashboard.getNumber(key, defaultValue);
		}
		SmartDashboard.putNumber(key, defaultValue);
		return defaultValue;
	}

	public RobotContainer() {
		configureButtonBindings();

		m_drive.setDefaultCommand(m_setSpeed);

		m_chooser.addOption("Tower Simple", autonMode.TowerSimple);
		m_chooser.addOption("Back Tower Simple", autonMode.BackTowerSimple);
		m_chooser.addOption("Trench Simple", autonMode.TrenchSimple);
		m_chooser.addOption("Tower Simple Forwards", autonMode.TowerSimpleForward);

		Shuffleboard.getTab("Autonomous").add(m_chooser);
	}

	private void configureButtonBindings() {
		new JoystickButton(leftStick, 2).whenPressed(new Flip(m_drive));
		new JoystickButton(rightStick, 2).whenPressed(() -> m_drive.setMaxOutput(0.5))
				.whenReleased(() -> m_drive.setMaxOutput(0.9));

		new JoystickButton(rightStick, 3).whenPressed(() -> m_drive.setMaxOutput(0.25))
				.whenReleased(() -> m_drive.setMaxOutput(0.9));

		new JoystickButton(rightStick, 4).whenPressed(() -> m_drive.setMaxOutput(0.25))
				.whenReleased(() -> m_drive.setMaxOutput(0.9));

		SmartDashboard.putData("Record", new DataRecorder(m_drive));
	}

	public Command getAutonomousCommand() {
		switch (m_chooser.getSelected()) {

		case TowerSimple:
			return new TowerSimple(m_drive).andThen(m_stop);
		case TowerSimpleForward:
			return new WaitCommand(1.0);
		case BackTowerSimple:
			return new WaitCommand(1.0);
		case TrenchSimple:
			return new WaitCommand(1.0);
		default:
			return new WaitCommand(1.0);
		}
	}

	public void teleopInit(Robot robot) {
		new Coast(m_drive);
		if (robot.m_autonomousCommand != null) {
			robot.m_autonomousCommand.cancel();
		}
	}
}