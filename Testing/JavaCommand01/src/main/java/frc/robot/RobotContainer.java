package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class RobotContainer {
  private final Drive m_Drive = new Drive();
  private final Command m_setDistance = new WaitCommand(1.0); // new SetDistance(m_Drive);
  private final Command m_setSpeed = new SetSpeed(m_Drive);

  public RobotContainer() {
    configureButtonBindings();
    m_Drive.setDefaultCommand(m_setSpeed);
  }

  private void configureButtonBindings() {
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