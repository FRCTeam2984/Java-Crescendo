// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {


  private MecanumDrive m_robotDrive ;
  private Joystick stick;

  @Override
  public void robotInit() {
    TalonFX frontLeft = new TalonFX(ConstantID.kFrontLeftChannel);
    TalonFX rearLeft = new TalonFX(ConstantID.kRearLeftChannel);
    TalonFX frontRight = new TalonFX(ConstantID.kFrontRightChannel);
    TalonFX rearRight = new TalonFX(ConstantID.kRearRightChannel);
    rearRight.setInverted(false);
    SendableRegistry.addChild(m_robotDrive, frontLeft);
    SendableRegistry.addChild(m_robotDrive, rearLeft);
    SendableRegistry.addChild(m_robotDrive, frontRight);
    SendableRegistry.addChild(m_robotDrive, rearRight);

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    //frontRight.setInverted(true);
    

    m_robotDrive = new MecanumDrive(frontLeft::set, rearLeft::set, frontRight::set, rearRight::set);

    stick = new Joystick(ConstantID.kJoystickChannel);
    // motor = new PWMSparkMax(13);


  }

  @Override
  public void teleopPeriodic() {
    // Use the joystick Y axis for forward movement, X axis for lateral
    // movement, and Z axis for rotation.
    double speedMultiplier = 0.5;
    m_robotDrive.driveCartesian(-stick.getY()*-1*speedMultiplier, -stick.getZ()*speedMultiplier, -stick.getX()*speedMultiplier);
    
    // frontRight.setInverted(true);
    // rearRight.setInverted(true);
    // frontLeft.set(.1);
    // rearLeft.set(.1);
    // frontRight.set(.1);
    // rearRight.set(.1);

  }
}
