package frc.robot.subsystems;

import java.util.function.Supplier;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

    private CANSparkMax climb = new CANSparkMax(60, MotorType.kBrushless);
    private CANEncoder climbEncoder = climb.getEncoder();

    public Supplier<Double> getClimbEncoder = () -> climbEncoder.getPosition();

    public Climber() {
        climb.restoreFactoryDefaults();
        climb.setIdleMode(IdleMode.kCoast);
        climb.setSecondaryCurrentLimit(250);
        climb.setSmartCurrentLimit(60, 60, 200000);

        climbEncoder.setPositionConversionFactor(42);
    }

    public void setClimbPower(double climberInput) {
        climb.set(climberInput);
    }
    // TODO: should we have some function which will stop the climber once it reaches max or min height? we could read the encoder
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Climber Position", getClimbEncoder.get());
    }
}