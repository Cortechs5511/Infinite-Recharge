/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  //this is actually init
  public Joystick leftStick = new Joystick(0);
  public Joystick rightStick = new Joystick(1);

  public CANSparkMax left0 = new CANSparkMax(10, MotorType.kBrushless);
  public CANSparkMax left1 = new CANSparkMax(11, MotorType.kBrushless);
  public SpeedControllerGroup left = new SpeedControllerGroup(left0, left1);

  public CANSparkMax right0 = new CANSparkMax(20, MotorType.kBrushless);
  public CANSparkMax right1 = new CANSparkMax(21, MotorType.kBrushless);
  public SpeedControllerGroup right = new SpeedControllerGroup(right0, right1);

  public CANPIDController leftNEOPID = left0.getPIDController();
  public CANPIDController rightNEOPID = right0.getPIDController();

  public CANEncoder leftenc = left0.getEncoder();
  public CANEncoder rightenc = right0.getEncoder();
  
  public Drive() {
    //basically init but not variables
    leftenc.setPositionConversionFactor(42);
    rightenc.setPositionConversionFactor(42);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
