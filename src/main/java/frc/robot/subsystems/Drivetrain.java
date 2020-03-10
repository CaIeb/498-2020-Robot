/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.team6479.lib.util.Limelight;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
  private final double CPR = 2048;
  private final double WHEEL_CIRCUMFERENCE = Math.PI * 5;
  private final double TRUE_DISTANCE_CONVERSION = WHEEL_CIRCUMFERENCE / CPR;

  private final ADIS16448_IMU gyro = new ADIS16448_IMU();

  private final WPI_VictorSPX motorRight1 = new WPI_VictorSPX(DrivetrainConstants.motorRight1);
  private final WPI_VictorSPX motorRight2 = new WPI_VictorSPX(DrivetrainConstants.motorRight2);
  private final WPI_VictorSPX motorRight3 = new WPI_VictorSPX(DrivetrainConstants.motorRight3);
  private final WPI_VictorSPX motorLeft1 = new WPI_VictorSPX(DrivetrainConstants.motorLeft1);
  private final WPI_VictorSPX motorLeft2 = new WPI_VictorSPX(DrivetrainConstants.motorLeft2);
  private final WPI_VictorSPX motorLeft3 = new WPI_VictorSPX(DrivetrainConstants.motorLeft3);

 
  private final SpeedControllerGroup rightDrive = new SpeedControllerGroup(motorRight1, motorRight2, motorRight3);
  private final SpeedControllerGroup leftDrive = new SpeedControllerGroup(motorLeft1, motorLeft2, motorLeft3);
  private final DifferentialDrive m_drive = new DifferentialDrive(leftDrive, rightDrive);

  private final Encoder rightEncoder = new Encoder(DrivetrainConstants.encoderRightA, DrivetrainConstants.encoderRightB, false);
  private final Encoder leftEncoder = new Encoder(DrivetrainConstants.encoderLeftA, DrivetrainConstants.encoderLeftB, true);
  



  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    configMotor(motorRight1, false);
    configMotor(motorRight2, false);
    configMotor(motorRight3, false);

    configMotor(motorLeft1, false);
    configMotor(motorLeft2, false);
    configMotor(motorLeft3, false);
  }

  public void stop() {
    leftDrive.set(0);
    rightDrive.set(0);
  }

  public void arcadeDrive(double speed, double turn) {
    if(Math.abs(motorRight1.get() + (motorLeft1.get()))/2 <= .02 ) {
      double rampSpeed = .1;
      motorLeft1.configOpenloopRamp(rampSpeed);
      motorLeft2.configOpenloopRamp(rampSpeed);
      motorLeft3.configOpenloopRamp(rampSpeed);
      motorRight1.configOpenloopRamp(rampSpeed);
      motorRight2.configOpenloopRamp(rampSpeed);
      motorRight3.configOpenloopRamp(rampSpeed);
    }
    else{
      motorLeft1.configOpenloopRamp(0);
      motorLeft2.configOpenloopRamp(0);
      motorLeft3.configOpenloopRamp(0);
      motorRight1.configOpenloopRamp(0);
      motorRight2.configOpenloopRamp(0);
      motorRight3.configOpenloopRamp(0);
    }
    m_drive.arcadeDrive(speed, turn);
    //rightDrive.set(forward - turn);
    //leftDrive.set(forward + turn);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    if(Math.abs(motorRight1.get() + (motorLeft1.get()))/2 <= .02 ) {
      double rampSpeed = .1;
      motorLeft1.configOpenloopRamp(rampSpeed);
      motorLeft2.configOpenloopRamp(rampSpeed);
      motorLeft3.configOpenloopRamp(rampSpeed);
      motorRight1.configOpenloopRamp(rampSpeed);
      motorRight2.configOpenloopRamp(rampSpeed);
      motorRight3.configOpenloopRamp(rampSpeed);
    }
    else{
      motorLeft1.configOpenloopRamp(0);
      motorLeft2.configOpenloopRamp(0);
      motorLeft3.configOpenloopRamp(0);
      motorRight1.configOpenloopRamp(0);
      motorRight2.configOpenloopRamp(0);
      motorRight3.configOpenloopRamp(0);
    }
    rightDrive.set(rightSpeed);
    leftDrive.set(leftSpeed);
  }
  public double getRightTrueDistance() {
    return rightEncoder.getDistance() * TRUE_DISTANCE_CONVERSION;
  }

  public double getLeftTrueDistance() {
    return leftEncoder.getDistance() * TRUE_DISTANCE_CONVERSION;
  }

  public double getTrueDistance() {
    return (getLeftTrueDistance() + getRightTrueDistance()) / 2;
  }

  public void resetEncoders() {
    rightEncoder.reset();
    leftEncoder.reset();
  }
  public double getDriveAngle() {
    return gyro.getGyroAngleY();
  }
  public void resetGyro() {
    gyro.reset();
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left", getLeftTrueDistance());
    SmartDashboard.putNumber("Right", getRightTrueDistance());
    SmartDashboard.putNumber("X offset", Limelight.getXOffset());
    SmartDashboard.putNumber("Area offset", Limelight.getArea());
    SmartDashboard.putNumber("Drive Angle", getDriveAngle());
  }
  

  private void configMotor(BaseMotorController motor, boolean isRight) {
    motor.setNeutralMode(NeutralMode.Brake);
    motor.setInverted(isRight);
  }
}



