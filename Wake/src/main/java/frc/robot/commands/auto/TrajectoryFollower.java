package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;

import frc.robot.subsystems.Drive;

public class TrajectoryFollower extends CommandBase {
	private Drive m_drive;
	private Trajectory m_trajectory;

	public TrajectoryFollower(Drive drive, Trajectory trajectory) {
		m_trajectory = trajectory;
		m_drive = drive;
		addRequirements(drive);
	}

	public RamseteCommand getPath() {
		RamseteCommand ramseteCommand = new RamseteCommand(m_trajectory, m_drive::getPose,
				new RamseteController(AutoConstants.kRamseteB, AutoConstants.kRamseteZeta),
				new SimpleMotorFeedforward(DriveConstants.ksVolts, DriveConstants.kvVoltSecondsPerMeter,
						DriveConstants.kaVoltSecondsSquaredPerMeter),
				DriveConstants.kDriveKinematics, m_drive::getWheelSpeeds,
				new PIDController(DriveConstants.kPDriveVel, 0, 0), new PIDController(DriveConstants.kPDriveVel, 0, 0),
				// RamseteCommand passes volts to the callback
				m_drive::tankDriveVolts, m_drive);

		return ramseteCommand;// .andThen(() -> m_drive.tankDriveVolts(0, 0));
	}
}
