/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import com.team6479.lib.util.Limelight;
import com.team6479.lib.util.Limelight.*;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;

public class LimelightAlign extends CommandBase {
  private Drivetrain drivetrain;
  private final double kSteer = 0.1;                
  private final double kDrive = 0.2;                   
  private final double TargetArea = 15.0;        
  private final double MaxDrive = 0.75;    
  private double turn_cmd;
  private double drive_cmd;
  private double areaTolerance = .01;
  private double xOffsetTolerance = .5;
  /**
   * Creates a new LimelightAlign.
   */
  public LimelightAlign(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Limelight.setLEDState(LEDState.On);
    Limelight.setCamMode(CamMode.VisionProcessor);
    new WaitCommand(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(Limelight.hasTarget() == true) {
      turn_cmd = Limelight.getXOffset() * kSteer;
      drive_cmd = (TargetArea - Limelight.getArea()) * kDrive;

      if (drive_cmd > MaxDrive)
      {
        drive_cmd = MaxDrive;
      }
    }
    else {
      drive_cmd = 0;
      turn_cmd = 0;
    }
    drivetrain.arcadeDrive(drive_cmd, turn_cmd);
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
    return Math.abs(Limelight.getXOffset()) <= xOffsetTolerance && Math.abs(Limelight.getArea()) <= areaTolerance;
  }
}
