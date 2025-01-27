package frc.robot;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

public class OI {
    private static OI oi;

    private Joystick leftStick = new Joystick(0);
    private Joystick rightStick = new Joystick(1);
    private XboxController controller = new XboxController(2);

    public Supplier<Double> getLeftY = () -> leftStick.getY();
    public Supplier<Double> getRightY = () -> rightStick.getY();

    public Supplier<Boolean> getWristUp = () -> controller.getRawButton(3);
    public Supplier<Boolean> getWristDown = () -> controller.getRawButton(2);

    public Supplier<Boolean> getIntake = () -> controller.getRawButton(4); // 40% output for intake and black wheel
    public Supplier<Boolean> getBackFeed = () -> controller.getRawButton(1);

    public Supplier<Boolean> getClimberUp = () -> (controller.getPOV()) == 0;
    public Supplier<Boolean> getClimberDown = () -> (controller.getPOV()) == 180;

    private OI() {
    }

    public void setLeftRumble(double input) {
        controller.setRumble(RumbleType.kLeftRumble, input);
    }

    public void setRightRumble(double input) {
        controller.setRumble(RumbleType.kRightRumble, input);
    }

    public static OI getInstance() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }
}