package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    private static OI oi;
    public Joystick leftStick = new Joystick(0);
    public Joystick rightStick = new Joystick(1);

    private OI() {}

    public static OI getInstance() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }
    public Joystick getLeftStick() {
        return leftStick;
    }
    public Joystick getRightStick() {
        return rightStick;
    }
    public boolean getIntake() { // sets intake to 90% output
        return leftStick.getRawButton(0); 
    }
    public boolean getWristUp() { // PID command up for wrist
        return leftStick.getRawButton(1); 
    }
    public boolean getWristDown() { // PID command down for wrist
        return rightStick.getRawButton(1);
    }
    public boolean getShooterLong() { // 4200RPM PID command for shooter (behind control panel)
        return rightStick.getRawButton(2);
    }    
    public boolean getShooterShort() {  // 3300RPM PID command for shooter (near init line)
        return leftStick.getRawButton(2);
    }
    
}