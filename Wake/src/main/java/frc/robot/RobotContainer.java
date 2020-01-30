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
  private final Drive m_Drive = new Drive();
  private final Intake m_Intake = new Intake();
  private final Feeder m_Feeder = new Feeder();
  private final Limelight m_Limelight = new Limelight();
  private final Shooter m_Shooter = new Shooter();

  private final SetFeederPower m_SetFeederPower = new SetFeederPower(m_Feeder, m_Shooter);

  private final SetDistance m_SetDistance = new SetDistance(m_Drive);
  private final SetSpeed m_SetSpeed = new SetSpeed(m_Drive);
  private final LimelightAlign m_LimelightAlign = new LimelightAlign(m_Drive, m_Limelight);
  
  private final Shoot m_Shoot = new Shoot(m_Shooter, m_Feeder, m_Limelight);
  //private final Accel m_Accel = new Accel(m_Shooter, m_Limelight); // not sure whether commands inherited in sequentialcommandgroup must be imported
  //private final Cruise m_Cruise = new Cruise(m_Shooter, m_Feeder);

  Joystick leftStick = new Joystick(0);
  Joystick rightStick = new Joystick(1);

  public RobotContainer() {
    configureButtonBindings();
    m_Drive.setDefaultCommand(m_SetSpeed);
    m_Feeder.setDefaultCommand(m_SetFeederPower);
  }

  private void configureButtonBindings() {
    new JoystickButton(leftStick, 1).toggleWhenPressed(m_LimelightAlign, true); // testing for limelight calibration
    new JoystickButton(rightStick, 1).whenHeld(m_Shoot, true); // button triggers sequential command group
    //SmartDashboard.putData("Record", new DataRecorder(m_Drive));
  } //toggleWhenPressed, whenHeld

  public Command getAutonomousCommand() {
    return m_SetDistance;
  }

  public void teleopInit(Robot robot) {
    if (robot.m_autonomousCommand != null) {
      robot.m_autonomousCommand.cancel();
    }
  }
}