package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase {
  public double x, y, area;
  private double distanceMultiplierRPM = 0.0;
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");

public Limelight() {}

  @Override
  public void periodic() {
    //read values periodically
    x = tx.getDouble(0.001); //continue working on getting x and tx
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);

    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area); 
  }

  public double calculateRPM() {
    double distance = ((63.65) / Math.tan(Math.toRadians(y+16.94))) * (((-Math.abs(y)) / 300) + 1);
    SmartDashboard.putNumber("Distance", distance);
    double rpm = distance * distanceMultiplierRPM;
    return rpm;
  }

  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }
  public double getArea() {
    return area;
  }
}