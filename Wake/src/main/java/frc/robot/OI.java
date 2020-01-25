package frc.robot;
import java.util.function.Supplier; 
import edu.wpi.first.wpilibj.Joystick;

public class OI {
    private static OI oi;

    private Joystick leftStick = new Joystick(0);
    private Joystick rightStick = new Joystick(1);

    public Supplier<Double> getLeftY = () -> leftStick.getY();
    public Supplier<Double> getRightY = () -> rightStick.getY();

    public Supplier<Boolean> getIntake = () -> leftStick.getRawButton(0); // 90% output for intake

    public Supplier<Boolean> getWristUp = () -> leftStick.getRawButton(1); // PID command up for wrist
    public Supplier<Boolean> getWristDown = () -> rightStick.getRawButton(1); // PID command down for wrist

    public Supplier<Boolean> getShooterShort = () -> leftStick.getRawButton(2); // PID Command for shooting near init line
    public Supplier<Boolean> getShooterLong = () -> rightStick.getRawButton(2); // PID Command for shooting behind control panel
    
    private OI() {}

    public static OI getInstance() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }
}