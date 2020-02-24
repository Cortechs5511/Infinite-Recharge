package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

public final class Constants {
  public static final class DriveConstants {
    public static final int kLeftMotor0Port = 10;
    public static final int kLeftMotor1Port = 11;
    public static final int kRightMotor0Port = 20;
    public static final int kRightMotor1Port = 21;

    public static final double kTrackwidthMeters = 0.69; // must be changed
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
        kTrackwidthMeters);

    public static final int kEncoderCPR = 42;
    public static final double kWheelDiameterMeters = 0.1524;
    public static final double kEncoderDistancePerPulse = (0.1524 * Math.PI) / (double) 42 * 8.2;
    public static final double kEncoderPulsesPerMeter = (1 / 0.1524 * Math.PI) * 8.2 * 42;

    public static final double ksVolts = 0.613;
    public static final double kvVoltSecondsPerMeter = 0.0031;
    public static final double kaVoltSecondsSquaredPerMeter = 0.00048;

    public static final double kPDriveVel = 8.5;

    public static final double kLeftP = 0.0305;
    public static final double kLeftI = 0;
    public static final double kLeftD = 15.2;
    public static final double kLeftFF = 0;

    public static final double kRightP = 0.0335;
    public static final double kRightI = 0;
    public static final double kRightD = 16.7;
    public static final double kRightFF = 0;

    public static final double kAngleP = 0.03; // not implemented yet pending final testing
    public static final double kAngleI = 0.02;
    public static final double kAngleD = 0.002;
  }

  public static final class FeederConstants {
    public static final int kWristPort = 30;
    public static final int kIntakePort = 31;

    public static final int kFeeder0Port = 40;
    public static final int kFeeder1Port = 41;
    public static final int kFeeder2Port = 42;
    public static final int kFeeder3Port = 43;

    public static final int kBottomSensorPort = 0;
    public static final int kTopSensorPort = 1;
    public static final int kGreenSensorPort = 2;
    public static final int kBlackSensorPort = 3;
  }

  public static final class ShooterConstants {
    public static final int kShoot0Port = 50;
    public static final int kShoot1Port = 51;

    public static final double kShootP = 0.000275; // not implemented yet pending final testing
    public static final double kShootI = 0;
    public static final double kShootD = 0.008;
    public static final double kShootFF = 0.000202;
  }

  public static final class ClimberConstants {
    public static final int kClimb0Port = 60;
    public static final int kClimb1Port = 61;
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