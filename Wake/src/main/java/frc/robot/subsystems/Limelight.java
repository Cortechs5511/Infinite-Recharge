package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase {
  private double x, y, area, distance;
  private double distanceMultiplierRPM = 3.66; // this is the main test item in this section TEST THIS TEST THIS
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");

  public Limelight() {
  }

  @Override
  public void periodic() {
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);

    SmartDashboard.putNumber("X", x);
    SmartDashboard.putNumber("Y", y);
    SmartDashboard.putNumber("Area", area);

    //distance = ((63.65) / Math.tan(Math.toRadians(y + 16.94))) * (((-Math.abs(y)) / 300) + 1); // in periodic for testing purposes only
    SmartDashboard.putNumber("Calculated Distance", distance);
  }

  public double calculateRPM() {
    distance = ((63.65) / Math.tan(Math.toRadians(y + 16.94))) * (((-Math.abs(y)) / 300) + 1);
    double rpm = (distance * distanceMultiplierRPM) + 2851; // need to figure out distance multiplier
    SmartDashboard.putNumber("RPM Setpoint", rpm);
    if (y != 0) {
      return rpm;
    } else {
      return 4200;
    }
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