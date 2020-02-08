
//this code is copied from spectrum (uses  319 trajectory)

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.subsystems.Drive;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class PathFollower extends SubsystemBase {
    private static final int k_ticks_per_rev = 344;
    private static final double k_wheel_diameter = 0.5;
    private static final double k_max_velocity = 7;

    private EncoderFollower m_left_follower;
    private EncoderFollower m_right_follower;

    private Drive m_drive;
    private Trajectory leftTraj, rightTraj;

    private Notifier m_follower_notifier;
    private boolean reverse = false;

    public PathFollower() {
        m_left_follower = new EncoderFollower();
        m_right_follower = new EncoderFollower();

        m_left_follower.configureEncoder(0, k_ticks_per_rev, k_wheel_diameter);
        // You must tune the PID values on the following line!
        m_left_follower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);

        m_right_follower.configureEncoder(0, k_ticks_per_rev, k_wheel_diameter);
        // You must tune the PID values on the following line!
        m_right_follower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);

        m_follower_notifier = new Notifier(this::followPath);
    }

    public void resetEncoders() {
        m_drive.resetLeftEnc();
        m_drive.resetRightEnc();
    }

    public void setSpeeds(double left, double right) {
        m_drive.setLeft(left);
        m_drive.setRight(right);
    }

    public void setTrajectories(Trajectory leftTraj, Trajectory rightTraj, boolean reverse) {
        this.leftTraj = leftTraj;
        this.rightTraj = rightTraj;
        m_left_follower.setTrajectory(leftTraj);
        m_right_follower.setTrajectory(rightTraj);
        this.reverse = reverse;
    }

    public void configurePIDVA(double kp, double ki, double kd, double kv, double ka) {
        m_right_follower.configurePIDVA(kp, ki, kd, kv, ka);
        m_left_follower.configurePIDVA(kp, ki, kd, kv, ka);
    }

    public void startPathFollowing() {
        m_follower_notifier.startPeriodic(leftTraj.get(0).dt);
    }

    public void stopPathFollowing() {
        m_follower_notifier.stop();
    }

    public boolean isFinished() {
        return m_left_follower.isFinished() || m_right_follower.isFinished();
    }

    private void followPath() {
        if (isFinished()) {
            m_follower_notifier.stop();
        } else {
            int leftPos = (int) Math.round(m_drive.getLeftPosition.get());
            int rightPos = (int) Math.round(m_drive.getRightPosition.get());

            double left_speed = m_left_follower.calculate(leftPos);
            double right_speed = m_right_follower.calculate(rightPos);

            double turn = 0;
            if (reverse) {
                setSpeeds(-1 * (right_speed - turn), -1 * (left_speed + turn));
            } else {
                setSpeeds(left_speed + turn, right_speed - turn);
            }
        }
    }
}