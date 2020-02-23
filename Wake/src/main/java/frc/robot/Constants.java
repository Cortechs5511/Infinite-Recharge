package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

public final class Constants {
  public static final class DriveConstants {
    public static final int kLeftMotor1Port = 10;
    public static final int kLeftMotor2Port = 11;
    public static final int kRightMotor1Port = 20;
    public static final int kRightMotor2Port = 21;

    public static final double kTrackwidthMeters = 0.69; // must be changed
    public static final DifferentialDriveKinematics kDriveKinematics =
        new DifferentialDriveKinematics(kTrackwidthMeters);
   
    public static final int kEncoderCPR = 42;
    public static final double kWheelDiameterMeters = 0.1524;
    public static final double kEncoderDistancePerPulse =
        (0.1524 * Math.PI) / (double) 42 * 8.2;

    public static final double ksVolts = 0.613;
    public static final double kvVoltSecondsPerMeter = 0.0031;
    public static final double kaVoltSecondsSquaredPerMeter = 0.00048;

    public static final double kPDriveVel = 8.5;
  }

  public static final class OIConstants {
    public static final int kLeftStickPort = 0;
    public static final int kRightStickPort = 1;
    public static final int kControllerPort = 2;
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;

    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;
  }
}