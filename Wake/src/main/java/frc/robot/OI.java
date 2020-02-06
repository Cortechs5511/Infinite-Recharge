package frc.robot;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj.Joystick;

public class OI {
    private static OI oi;

    public Joystick leftStick = new Joystick(0);
    private Joystick rightStick = new Joystick(1);

    public Supplier<Double> getLeftY = () -> leftStick.getY();
    public Supplier<Double> getRightY = () -> rightStick.getY();

    public Supplier<Boolean> getWristUp = () -> leftStick.getRawButton(2);
    public Supplier<Boolean> getWristDown = () -> rightStick.getRawButton(2);

    public Supplier<Boolean> getIntake = () -> leftStick.getRawButton(3); // 40% output for intake
    public Supplier<Boolean> getFeeder = () -> rightStick.getRawButton(3); // 40% output for feeder

    private OI() {
    }

    public static OI getInstance() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }
}