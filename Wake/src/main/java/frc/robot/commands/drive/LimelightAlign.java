package frc.robot.commands.drive;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class LimelightAlign extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drive m_drive;
  private Limelight m_limelight;
  private double val;

  public LimelightAlign(Drive drive, Limelight limelight) {
    m_drive = drive;
    m_limelight = limelight;
    addRequirements(drive);
    addRequirements(limelight);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    val = m_limelight.getX();

    m_drive.setLeftPIDReference(0);

    if (Math.abs(val) > 28) {
      val = (28 * (val/Math.abs(val)));
    } else if (Math.abs(val) < 0.5) { // deadband angle should be tuned
      val = 0;
    }

    m_drive.limelightPID(val);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.setLeft(0);
    m_drive.setRight(0);
  }

  @Override
  public boolean isFinished() {
    if ((val == 0) && ((m_drive.getLeftVelocity.get() == 0) && (m_drive.getRightVelocity.get() == 0))) {
      return true;
    } else {
      return false;
    }
  }
}
