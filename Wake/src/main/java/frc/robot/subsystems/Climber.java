package frc.robot.subsystems;

import java.util.function.Supplier;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

    private CANSparkMax climb = new CANSparkMax(60, MotorType.kBrushless);
    private CANEncoder climbEncoder = climb.getEncoder();

    public Supplier<Double> getClimbEncoder = () -> climbEncoder.getPosition();

    public Climber() {
    }

    public void setClimbPower(double climberInput) {
        climb.set(climberInput);
    }

    @Override
    public void periodic() {
    }
}