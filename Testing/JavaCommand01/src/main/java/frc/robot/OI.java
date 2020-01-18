package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    public Joystick leftStick = new Joystick(0);
    public Joystick rightStick = new Joystick(1);

    public OI() {}

    public Joystick getLeftStick() {
        return leftStick;
    }

    public Joystick getRightStick() {
        return rightStick;
    }
}