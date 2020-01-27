package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.drive.*;
import frc.robot.commands.shooter.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final Drive m_Drive = new Drive();
  private final Intake m_Intake = new Intake();
  private final Limelight m_Limelight = new Limelight();
  private final Shooter m_Shooter = new Shooter();

  private final Command m_SetDistance = new SetDistance(m_Drive);
  private final Command m_SetSpeed = new SetSpeed(m_Drive);
  private final Command m_LimelightAlign = new LimelightAlign(m_Drive, m_Limelight);
  
  private final Command m_Shoot = new Shoot(m_Shooter, m_Intake, m_Limelight);
  private final Command m_Accel = new Accel(m_Shooter, m_Limelight);
  private final Command m_ShooterStop = new Cruise(m_Shooter, m_Intake);

  Joystick leftStick = new Joystick(0);


  public RobotContainer() {
    configureButtonBindings();
    m_Drive.setDefaultCommand(m_SetSpeed);
  }

  private void configureButtonBindings() {
    new JoystickButton(leftStick, 1).toggleWhenPressed(m_LimelightAlign, true);
  }

  public Command getAutonomousCommand() {
    return m_SetDistance;
  }

public void teleopInit(Robot robot) {
    if (robot.m_autonomousCommand != null) {
      robot.m_autonomousCommand.cancel();
    }
  }
}