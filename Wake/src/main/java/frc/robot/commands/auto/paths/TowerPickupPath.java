package frc.robot.commands.auto.paths;

import frc.paths.TowerPickup;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

//3, 11 for the index position in TowerPickup
public class TowerPickupPath extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Drive m_drive;
  private double[][] points = TowerPickup.points;
  private double leftReference, rightReference;
  private double leftTarget, rightTarget;
  private static final double TICKS_PER_FOOT = 688.8 / Math.PI;
  private int row = 1;

  public TowerPickupPath(Drive drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    m_drive.resetLeftEnc();
    m_drive.resetRightEnc();
    
    leftReference = points[0][3] * TICKS_PER_FOOT;
    rightReference = points[0][11] * TICKS_PER_FOOT;

    m_drive.setLeftPIDReference(leftReference);
    m_drive.setRightPIDReference(rightReference);

    leftTarget = ((points[1][3] * TICKS_PER_FOOT - leftReference) * 0.5) + leftReference;
    rightTarget = ((points[1][11] * TICKS_PER_FOOT - rightReference) * 0.5) + rightReference;
  }

  @Override
  public void execute() {
    if ((m_drive.getLeftPosition.get() > leftTarget) && (m_drive.getRightPosition.get() > rightTarget)) {
      row++;
      leftReference = points[row][3] * TICKS_PER_FOOT;
      rightReference = points[row][11] * TICKS_PER_FOOT;

      leftTarget = ((points[row + 1][3]* TICKS_PER_FOOT - leftReference) * 0.5) + leftReference;
      rightTarget = ((points[row + 1][11]* TICKS_PER_FOOT - rightReference) * 0.5) + rightReference;

      m_drive.setLeftPIDReference(leftReference);
      m_drive.setRightPIDReference(rightReference);

    SmartDashboard.putNumber("Left Reference", leftReference);
    SmartDashboard.putNumber("Right Reference", rightReference);

    SmartDashboard.putNumber("Left Target", leftTarget);
    SmartDashboard.putNumber("Right Target", rightTarget);

    SmartDashboard.putNumber("Current Auto Row", row);
    }
  }

  @Override
  public void end(boolean interrupted) {
    row = 1;
  }

  @Override
  public boolean isFinished() {
    return row > 194;
  }
}
