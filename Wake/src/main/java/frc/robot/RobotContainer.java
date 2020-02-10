package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.drive.*;
import frc.robot.commands.auto.*;
import frc.robot.commands.auto.paths.*;
import frc.robot.commands.shooter.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RobotContainer {
  private final Drive m_drive = new Drive();
  private final Intake m_intake = new Intake();
  private final Feeder m_feeder = new Feeder();
  private final Limelight m_limelight = new Limelight();
  private final Shooter m_shooter = new Shooter();
  //private final Climber m_climber = new Climber();

  private final SetFeederPower m_setFeederPower = new SetFeederPower(m_feeder);

  private final SetDistance m_setDistance = new SetDistance(420, m_drive);
  private final TowerSimplePath m_simpleTower = new TowerSimplePath(m_drive);
  private final SetSpeed m_setSpeed = new SetSpeed(m_drive);
  
  private final Shoot m_shoot = new Shoot(m_shooter, m_feeder, m_limelight);
  private final ShootAlign m_shootAlign = new ShootAlign(m_drive, m_shooter, m_feeder, m_limelight);

  Joystick leftStick = new Joystick(0);
  Joystick rightStick = new Joystick(1);

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    m_drive.setDefaultCommand(m_setSpeed);
    m_feeder.setDefaultCommand(m_setFeederPower);

    m_chooser.addOption("Drive Forwards Test", m_setDistance);
    m_chooser.addOption("Tower Simple", m_simpleTower);

    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  private void configureButtonBindings() {
    new JoystickButton(leftStick, 1).whenPressed(m_shoot, true); 
    new JoystickButton(rightStick, 1).whenPressed(m_shootAlign, true);
    SmartDashboard.putData("Record", new DataRecorder(m_drive));
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  public void teleopInit(Robot robot) {
    if (robot.m_autonomousCommand != null) {
      robot.m_autonomousCommand.cancel();
    }
  }
}