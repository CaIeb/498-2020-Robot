/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class FrontRoller extends CommandBase {
  private Intake intake;
  private DoubleSupplier backIntakeSupplier;
  private DoubleSupplier backOuttakeSupplier;
  private boolean isIntaking;
  /**
   * Creates a new FrontRoller.
   */
  public FrontRoller(Intake intake, DoubleSupplier backIntakeSupplier, DoubleSupplier backOuttakeSupplier, boolean isIntaking) {
    this.intake = intake;
    this.backIntakeSupplier = backIntakeSupplier;
    this.backOuttakeSupplier = backOuttakeSupplier;
    this.isIntaking = isIntaking;
    addRequirements(intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(isIntaking == true){
    intake.set(1, backIntakeSupplier.getAsDouble() * .8 - backOuttakeSupplier.getAsDouble());
    }
    else if (isIntaking == false){
      intake.set(-1, backIntakeSupplier.getAsDouble() * .8 - backOuttakeSupplier.getAsDouble());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return intake.getBackMotorSpeed() <= -.05; // Stop if direction is reversed
  }
}
