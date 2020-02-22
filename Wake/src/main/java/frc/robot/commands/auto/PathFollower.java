package frc.robot.commands.auto;

import frc.robot.subsystems.Drive;
import frc.team2363.commands.HelixFollower;
import frc.team2363.controller.PIDController;
import com.team319.trajectory.Path;

public class PathFollower extends HelixFollower {

  private final Drive m_drive;

  private final PIDController headingController = new PIDController(15, 0, 0, 0.001);
  private final PIDController distanceController = new PIDController(10, 0, 0, 0.001);

  /**
   * Creates a new PathFollower.
   */
  public PathFollower(Path path, Drive drive) {
    super(path);
    addRequirements(drive);
    m_drive = drive;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void resetDistance() {
    m_drive.resetLeftEnc();
    m_drive.resetRightEnc();
  }

  @Override
  public PIDController getHeadingController() {
    return headingController;
  }

  @Override
  public PIDController getDistanceController() {
    return distanceController;
  }

  @Override
  public double getCurrentDistance() {
    return ((m_drive.getLeftPosition.get() + m_drive.getRightPosition.get()) / 2);
  }

  @Override
  public double getCurrentHeading() {
    return 0;//Math.toRadians(m_drive.getHeading());
  }

  @Override
  public void useOutputs(double left, double right) {
    m_drive.setLeftPIDReference(left);
    m_drive.setRightPIDReference(right);
  }
}