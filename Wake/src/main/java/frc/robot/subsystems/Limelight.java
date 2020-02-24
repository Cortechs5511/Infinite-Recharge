package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase {
  private double x, y, v, area, distance;
  
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  private NetworkTableEntry tv = table.getEntry("tv");
  private NetworkTableEntry ledMode = table.getEntry("ledMode");

  public Limelight() {
    ledMode.setNumber(1); // sets lights off
    SmartDashboard.putNumber("RPM Setpoint", 0);
  }

  @Override
  public void periodic() {
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    v = tv.getDouble(0.0);
    area = ta.getDouble(0.0);

    SmartDashboard.putNumber("X", x);
    SmartDashboard.putNumber("Y", y);
    SmartDashboard.putNumber("Area", area);
    
    //distance = ((63.65) / Math.tan(Math.toRadians(y + 16.94))) * (((-Math.abs(y)) / 300) + 1); // in periodic for testing
    //SmartDashboard.putNumber("Calculated Distance", distance);
  }

  public double calculateRPM() {
    distance = ((63.65) / Math.tan(Math.toRadians(y + 16.94))) * (((-Math.abs(y)) / 300) + 1);
    SmartDashboard.putNumber("Calculated Distance", distance);
    
    // 0.00913x^2 -2.69x + 3647
    double rpm = (0.00913 * Math.pow(distance, 2)) - (2.69 * distance) + 3575;
    SmartDashboard.putNumber("RPM Setpoint", rpm);
    
    if (v != 0) { // if image not captured, return default of 0
      return rpm;
    } else {
      return 0;
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

  public double getLightStatus() {
    return ledMode.getDouble(1); 
  }

  public void setLightStatus(double input) {
    ledMode.setNumber(input); // 3 = on, 1 = off
  }
}