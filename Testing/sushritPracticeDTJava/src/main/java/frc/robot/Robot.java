package frc.robot;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;


public class Robot extends TimedRobot {
  private CANSparkMax frontLeft;
  private CANSparkMax backLeft;
  private CANSparkMax frontRight; 
  private CANSparkMax backRight; 

  private Joystick leftStick;
  private Joystick rightStick; 

  private double leftStickInput;
  private double rightStickInput; 

  private SpeedControllerGroup left; 
  private SpeedControllerGroup right; 


  @Override
  public void robotInit() {
   leftStick = new Joystick(0); 
   rightStick = new Joystick(1);

   // need to add ids not sure what they are right now at the moment
   frontRight = new CANSparkMax();
   backRight = new CANSparkMax(); 

   frontLeft = new CanSparkMax();
   backLeft = new CanSparkMax(); 
   
   right = new SpeedControllerGroup (frontRight, backRight);
   left = new SpeedControllerGroup (frontLeft, backLeft); 


  
  @Override
  public void teleopPeriodic() {
    leftStickInput = leftStick.getY();
    rightStickInput = rightStick.getY();
    left.set(leftStickInput);
    right.set(rightStickInput);
  }

 