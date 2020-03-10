/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoCurve extends CommandBase {
  private final Drivetrain drivetrain;
  private final double angle;
  private final double driveSpeed;
  private final double turnSpeed;
  /**
   * Creates a new AutoCurve.
   */
  public AutoCurve(Drivetrain drivetrain, double angle, double driveSpeed, double turnSpeed) {
    this.angle = angle;
    this.driveSpeed = driveSpeed;
    this.turnSpeed = turnSpeed;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(driveSpeed, turnSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
    drivetrain.resetGyro();
  }

  // ReturnSpeeds true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(drivetrain.getDriveAngle()) >= angle);
  }
}
