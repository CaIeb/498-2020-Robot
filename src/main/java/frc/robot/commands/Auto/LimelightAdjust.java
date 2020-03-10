/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import com.team6479.lib.util.Limelight;
import com.team6479.lib.util.Limelight.CamMode;
import com.team6479.lib.util.Limelight.LEDState;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class LimelightAdjust extends CommandBase {
  private final Drivetrain drivetrain;
  private final double SPEED = .75;
  /**
   * Drives Back until a target is found
   */
  public LimelightAdjust(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Limelight.setLEDState(LEDState.On);
    Limelight.setCamMode(CamMode.VisionProcessor);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(-SPEED, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
    Limelight.setLEDState(LEDState.Off);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Limelight.hasTarget();
  }
}
