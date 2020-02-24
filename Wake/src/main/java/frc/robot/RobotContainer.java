package frc.robot;

import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.*;
import frc.robot.commands.drive.*;
import frc.robot.commands.auto.*;
//import frc.robot.commands.auto.paths.*;
import frc.robot.commands.shooter.*;
import frc.robot.commands.climber.*;
import frc.robot.subsystems.*;

import java.util.List;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RobotContainer {
  private final Drive m_drive = new Drive();
  private final Intake m_intake = new Intake();
  private final Feeder m_feeder = new Feeder();
  private final Limelight m_limelight = new Limelight();
  private final Shooter m_shooter = new Shooter();
  private final Climber m_climber = new Climber();

  private final SetFeederPower m_setFeederPower = new SetFeederPower(m_feeder);

  private final ManualClimb m_manualClimb =   new ManualClimb(m_climber);

  private final SetDistance m_setDistance = new SetDistance(420 * 4, m_drive); // DO NOT RUN WITH CURRENT PID CONFIG
  private final SetSpeed m_setSpeed = new SetSpeed(m_drive);

  private final ShootAlign m_fastShootAlign = new ShootAlign(0.5, -1, m_drive, m_shooter, m_feeder, m_limelight);
  private final ShootAlign m_slowShootAlign = new ShootAlign(0.5, 5, m_drive, m_shooter, m_feeder, m_limelight);
  private final Shoot m_fastShoot = new Shoot(-1, m_shooter, m_feeder, m_limelight);
  private final Shoot m_slowShoot = new Shoot(5, m_shooter, m_feeder, m_limelight);

  private final StopShooter m_stopShooter = new StopShooter(m_shooter, m_limelight, m_feeder, m_drive);

  private final LightToggle m_lightToggle = new LightToggle(m_limelight);

    
  Joystick leftStick = new Joystick(0);
  Joystick rightStick = new Joystick(1);
  XboxController controller = new XboxController(2);

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();

    m_drive.setDefaultCommand(m_setSpeed);
    m_feeder.setDefaultCommand(m_setFeederPower);
    m_climber.setDefaultCommand(m_manualClimb);

    m_chooser.addOption("TimedAuton", new TimedAuton(m_drive, m_shooter, m_feeder, m_limelight, 3) );
    m_chooser.addOption("DO NOT RUN", m_setDistance);
    
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  private void configureButtonBindings() {
    new JoystickButton(controller, 1).whenPressed(m_slowShoot, true);
    new JoystickButton(controller, 3).whenPressed(m_fastShoot, true);
    new JoystickButton(controller, 4).whenPressed(m_slowShootAlign, true);
    new JoystickButton(controller, 2).whenPressed(m_fastShootAlign, true);

    new JoystickButton(controller, 8).whenPressed(m_stopShooter, false);
    new JoystickButton(controller, 7).whenPressed(m_lightToggle, true);

    new JoystickButton(leftStick, 2).whenPressed(new Flip(m_drive));
    new JoystickButton(rightStick, 2)
        .whenPressed(() -> m_drive.setMaxOutput(0.5))
        .whenReleased(() -> m_drive.setMaxOutput(0.9));

    new JoystickButton(rightStick, 3)
        .whenPressed(() -> m_drive.setMaxOutput(0.25))
        .whenReleased(() -> m_drive.setMaxOutput(0.9));

    new JoystickButton(rightStick, 4)
        .whenPressed(() -> m_drive.setMaxOutput(0.25))
        .whenReleased(() -> m_drive.setMaxOutput(0.9));
      

    SmartDashboard.putData("Stop Shooting", m_stopShooter);
    SmartDashboard.putData("Record", new DataRecorder(m_drive));
    SmartDashboard.putData("Timed Auton",new TimedAuton(m_drive,m_shooter,m_feeder,m_limelight,3));
  }

  public Command getAutonomousCommand() {
    // TODO: Return user selected auton
    //return m_chooser.getSelected();
    var autoVoltageConstraint =
        new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(DriveConstants.ksVolts,
                                       DriveConstants.kvVoltSecondsPerMeter,
                                       DriveConstants.kaVoltSecondsSquaredPerMeter),
            DriveConstants.kDriveKinematics,
            9);

    // Create config for trajectory
    TrajectoryConfig config =
        new TrajectoryConfig(AutoConstants.kMaxSpeedMetersPerSecond,
                             AutoConstants.kMaxAccelerationMetersPerSecondSquared)
            // Add kinematics to ensure max speed is actually obeyed
            .setKinematics(DriveConstants.kDriveKinematics)
            // Apply the voltage constraint
            .addConstraint(autoVoltageConstraint);

    // An example trajectory to follow.  All units in meters.
    Trajectory towerSimple = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0, 0, new Rotation2d(0)),
        // Pass through these two interior waypoints, making an 's' curve path
        List.of(
            new Translation2d(1, 1),
            new Translation2d(2, -1)
        ),
        // End 3 meters straight ahead of where we started, facing forward
        new Pose2d(3, 0, new Rotation2d(0)),
        // Pass config
        config
    );

    RamseteCommand ramseteCommand = new RamseteCommand(
        towerSimple,
        m_drive::getPose,
        new RamseteController(AutoConstants.kRamseteB, AutoConstants.kRamseteZeta),
        new SimpleMotorFeedforward(DriveConstants.ksVolts,
                                   DriveConstants.kvVoltSecondsPerMeter,
                                   DriveConstants.kaVoltSecondsSquaredPerMeter),
        DriveConstants.kDriveKinematics,
        m_drive::getWheelSpeeds,
        new PIDController(DriveConstants.kPDriveVel, 0, 0),
        new PIDController(DriveConstants.kPDriveVel, 0, 0),
        // RamseteCommand passes volts to the callback
        m_drive::tankDriveVolts,
        m_drive
    );

    // Run path following command, then stop at the end.
    return ramseteCommand.andThen(() -> m_drive.tankDriveVolts(0, 0));
  }

  public void teleopInit(Robot robot) {
    if (robot.m_autonomousCommand != null) {
      robot.m_autonomousCommand.cancel();
    }
  }
}