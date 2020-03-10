/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class Climber extends SubsystemBase {
  public enum ClimbPosition {
    Start(0), 
    Up(-30000), 
    Down(-78000);

    public double position;
    private ClimbPosition(double position) {
      this.position = position;
    }
  }
  private final TalonSRX motor1 = new TalonSRX(ClimberConstants.motor1);
  private final TalonSRX motor2 = new TalonSRX(ClimberConstants.motor2);
  private final PowerDistributionPanel pdp = new PowerDistributionPanel();


  /**
   * Creates a new Climber.
   */
  public Climber() {
    motor1.configFactoryDefault();
    motor2.configFactoryDefault();

    motor1.setNeutralMode(NeutralMode.Brake);
    motor2.setNeutralMode(NeutralMode.Brake);

    motor2.follow(motor1);

    motor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  public void set(double speed) {
    motor1.set(ControlMode.PercentOutput, speed);
  }
  public void setEncoderValue(double encoderValue) {
    motor1.setSelectedSensorPosition((int) Math.round(encoderValue));
  }
  public double getEncoderValue() {
    return -motor1.getSelectedSensorPosition();
  }
  public void stop() {
    motor1.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("ClimberValue", getEncoderValue());
    SmartDashboard.putNumber("Current 14", pdp.getCurrent(14));
    SmartDashboard.putNumber("Current 15", pdp.getCurrent(15));
    SmartDashboard.putNumber("Total Current", pdp.getTotalCurrent());
  }
}
