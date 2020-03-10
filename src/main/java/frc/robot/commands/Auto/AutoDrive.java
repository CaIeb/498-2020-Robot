/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase {
  /**
   * Creates a new AutoDrive.
   */
  private final Drivetrain drivetrain;
  private final double speed;
  private final double distance;
  private double leftDriveSpeed;
  private double rightDriveSpeed;
  private double driveError;
  private double leftSpeed;
  private double rightSpeed;
  private double TOLERANCE = .05;
  private double BALANCE_SCALE;// = 1/TOLERANCE;

  public AutoDrive(Drivetrain drivetrain, double distance, double speed) {
    this.drivetrain = drivetrain;
    this.speed = speed;
    this.distance = distance;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.resetEncoders();
    leftSpeed = speed;
    rightSpeed = speed;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    driveError = -drivetrain.getLeftTrueDistance() + drivetrain.getRightTrueDistance();
    BALANCE_SCALE = .02;
    
    if (driveError < -TOLERANCE) {
      rightSpeed = speed + BALANCE_SCALE;
      leftSpeed = speed - BALANCE_SCALE;
      rightDriveSpeed = rightSpeed;
      leftDriveSpeed = leftSpeed;
    }
    else if (driveError > TOLERANCE) {
      rightSpeed = speed - BALANCE_SCALE;
      leftSpeed = speed + BALANCE_SCALE;
      rightDriveSpeed = rightSpeed;
      leftDriveSpeed = leftSpeed;
    }
    else {
      rightDriveSpeed = rightSpeed;
      leftDriveSpeed = leftSpeed;
    }
    drivetrain.tankDrive(leftDriveSpeed, -rightDriveSpeed);
    rightSpeed = rightDriveSpeed;
    leftSpeed = leftDriveSpeed;
    SmartDashboard.putNumber("Drive Error", driveError);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
    drivetrain.resetEncoders();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(drivetrain.getRightTrueDistance()) >= distance;
  }
}
