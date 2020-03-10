/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WristConstants;

public class Wrist extends SubsystemBase {
  public enum WristPosition {
    Home(.68), 
    Score(.575), 
    Load(.62), 
    Collect(.3);

    public double position;
    private WristPosition(double position) {
      this.position = position;
    }
  }

  private final TalonSRX motor = new TalonSRX(WristConstants.motor);
  private final Potentiometer potentiometer = new AnalogPotentiometer(WristConstants.potentiometer);
  private final DigitalInput wristUpSensor = new DigitalInput(WristConstants.wristUpSensor);
  private final DigitalInput wristDownSensor = new DigitalInput(WristConstants.wristDownSensor);

  /**
   * Creates a new Wrist.
   */
  public Wrist() {
    motor.configFactoryDefault();
    motor.setNeutralMode(NeutralMode.Brake);
  }

  public void set(double speed) {
    motor.set(ControlMode.PercentOutput, speed);
  }

  public void stop() {
    motor.set(ControlMode.PercentOutput, 0);
  }

  public double getCurrentAngle() {
    return potentiometer.get();
  }

  public boolean getWristUp() {
    return !wristUpSensor.get();
  }

  public boolean getWristDown() {
    return !wristDownSensor.get();
  }

  public boolean getWristFree() {
    return !getWristUp() && !getWristDown();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("isUp", getWristUp());
    SmartDashboard.putBoolean("isDown", getWristDown());
    SmartDashboard.putNumber("Wrist Position", getCurrentAngle());
    // SmartDashboard.putNumber("Wrist Output", motor.getMotorOutputPercent());
  }
}
