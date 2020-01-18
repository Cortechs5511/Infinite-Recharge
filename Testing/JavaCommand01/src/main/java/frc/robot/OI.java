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
}