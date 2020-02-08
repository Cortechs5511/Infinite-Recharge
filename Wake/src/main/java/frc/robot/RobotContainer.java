package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.drive.*;
import frc.robot.commands.auto.*;
import frc.robot.commands.shooter.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final Drive m_drive = new Drive();
  private final Intake m_intake = new Intake();
  private final Feeder m_feeder = new Feeder();
  private final Limelight m_limelight = new Limelight();
  private final Shooter m_shooter = new Shooter();

  private final SetFeederPower m_setFeederPower = new SetFeederPower(m_feeder, m_shooter);

  private final SetDistance m_setDistance = new SetDistance(m_drive);
  private final SetSpeed m_setSpeed = new SetSpeed(m_drive);
  private final LimelightAlign m_limelightAlign = new LimelightAlign(m_drive, m_limelight);
  
  private final Shoot m_shoot = new Shoot(m_shooter, m_feeder, m_limelight);
  private final ShootAlign m_shootAlign = new ShootAlign(m_drive, m_shooter, m_feeder, m_limelight);
  //private final Accel m_Accel = new Accel(m_shooter, m_limelight); // not sure whether commands inherited in sequentialcommandgroup must be imported
  //private final Cruise m_Cruise = new Cruise(m_shooter, m_feeder);

  Joystick leftStick = new Joystick(0);
  Joystick rightStick = new Joystick(1);

  public RobotContainer() {
    configureButtonBindings();
    m_drive.setDefaultCommand(m_setSpeed);
    m_feeder.setDefaultCommand(m_setFeederPower);
  }

  private void configureButtonBindings() {
    new JoystickButton(leftStick, 1).whenHeld(m_shoot, true); 
    new JoystickButton(rightStick, 1).whenHeld(m_shootAlign, true);
    SmartDashboard.putData("Record", new DataRecorder(m_drive));
  }

  public Command getAutonomousCommand() {
    return m_setDistance;
  }

  public void teleopInit(Robot robot) {
    if (robot.m_autonomousCommand != null) {
      robot.m_autonomousCommand.cancel();
    }
  }
}