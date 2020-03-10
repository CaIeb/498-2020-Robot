/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

public class MoveWrist extends CommandBase {
  private final double POSITION_TOLLERANCE = .023;
  
  // private final double POSITION_TOLLERANCE = .015;
  private final double LESS_SPEED = .25;
  private final double DOWNSPEED = .85;
  private final double UPSPEED = .9;
  public WristPosition startPosition = WristPosition.Home;
  private final Wrist wrist;
  private final WristPosition position;

  private double wristError;
  private boolean isDone = false;

  /**
   * Creates a new MoveWrist.
   */
  public MoveWrist(Wrist wrist, WristPosition position) {
    this.wrist = wrist;
    addRequirements(wrist);
    this.position = position;
  } 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isDone = false;
    SmartDashboard.putString("Wrist Position Name", position.name());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(this.position.position >= position.position) {
    //   isDone = true;
    //   return;
    // }
    // Don't do extra work if the sensors are triggered
    if (((position == WristPosition.Collect) && wrist.getWristDown()) || ((position == WristPosition.Home) && wrist.getWristUp())) {
      isDone = true;
      return;
    }
    /**
     * Calculate the offset from the target position
     * 
     * Positive = Below Target
     * Negative = Above Target
     */
    wristError = position.position - wrist.getCurrentAngle();
    SmartDashboard.putNumber("Wrist Error", wristError);
    // SmartDashboard.putNumber("Wrist Error", wristError);
    // If above the target we must go down to reach it
    if(((position == WristPosition.Load) || (position == WristPosition.Score) || (position == WristPosition.Home)) && (startPosition != WristPosition.Collect)) {
      if(wristError > 0) {
      wrist.set(UPSPEED);
      } 
      else if(wristError < 0) {
        wrist.set(-DOWNSPEED);
      }
    }

    else if(((position == WristPosition.Load) || (position == WristPosition.Score) || (position == WristPosition.Home)) && (startPosition == WristPosition.Collect)) {
      if(wristError > 0) {
      wrist.set(UPSPEED);
      } 
      else if(wristError < 0) {
        wrist.set(-DOWNSPEED);
      }
    }
    else if(position == WristPosition.Load && (startPosition == WristPosition.Home || startPosition == WristPosition.Score)) {
      wrist.set(.4);
    }
    else if(position == WristPosition.Collect) {
      wrist.set(-DOWNSPEED);
    }
    else if (wristError < -POSITION_TOLLERANCE) {
      wrist.set(-LESS_SPEED);
    } 
    else if (wristError > POSITION_TOLLERANCE) {
      wrist.set(LESS_SPEED);
    }
    else {
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    wrist.stop();
    startPosition = position;
    SmartDashboard.putString("Previous Wrist Position", startPosition.name());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(wristError) <= POSITION_TOLLERANCE || isDone;
  }
}
