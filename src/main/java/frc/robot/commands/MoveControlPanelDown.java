/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

public class MoveControlPanelDown extends CommandBase {
  private final ControlPanel controlPanel;
  private final double SPEED = .9;
  /**
   * Creates a new MoveControlPanelDown.
   */
  public MoveControlPanelDown(ControlPanel controlPanel) {
    this.controlPanel = controlPanel;
    addRequirements(controlPanel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    controlPanel.setLinear(SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    controlPanel.setLinear(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (controlPanel.getDownSensor() == true);
  }
}
