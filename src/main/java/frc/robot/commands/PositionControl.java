/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class PositionControl extends CommandBase {
  private ColorWheel colorWheel;
  private double SPEED = .25;
  /**
   * Creates a new PositionControl.
   */
  public PositionControl(ColorWheel colorWheel) {
    this.colorWheel = colorWheel;
    addRequirements(colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  //Red and Blue//Yellow and Green// are swapped because of field Sensor
  public void execute() {
    if (
    (ColorWheel.getTargetColor() == "R" && ColorWheel.getClosestColor() == "Y") || //Inverse is Green
    (ColorWheel.getTargetColor() == "Y" && ColorWheel.getClosestColor() == "B") || //Inverse is Red
    (ColorWheel.getTargetColor() == "B" && ColorWheel.getClosestColor() == "G") || //Really Yellow
    (ColorWheel.getTargetColor() == "G" && ColorWheel.getClosestColor() == "R"))   //Inverse is Blue
    {
      colorWheel.setMotor(-SPEED);
    }
    else{
      colorWheel.setMotor(SPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorWheel.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return ColorWheel.getTargetColor() == ColorWheel.getClosestColor();
  }
}
