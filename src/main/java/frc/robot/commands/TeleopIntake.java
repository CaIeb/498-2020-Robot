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

public class TeleopIntake extends CommandBase {
  private final Intake intake;

  private final DoubleSupplier frontIntakeSupplier;
  private final DoubleSupplier frontOuttakeSupplier;
  private final DoubleSupplier backtIntakeSupplier;
  private final DoubleSupplier backOuttakeSupplier;

  /**
   * Creates a new TeleopIntake.
   */
  public TeleopIntake(Intake intake, DoubleSupplier frontIntakeSupplier, DoubleSupplier frontOuttakeSupplier, DoubleSupplier backtIntakeSupplier, DoubleSupplier backOuttakeSupplier) {
    this.intake = intake;
    addRequirements(intake);

    this.frontIntakeSupplier = frontIntakeSupplier;
    this.frontOuttakeSupplier = frontOuttakeSupplier;
    this.backtIntakeSupplier = backtIntakeSupplier;
    this.backOuttakeSupplier = backOuttakeSupplier;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.set(
      frontIntakeSupplier.getAsDouble() - frontOuttakeSupplier.getAsDouble(), // Front Speed
      backtIntakeSupplier.getAsDouble() * .8 - backOuttakeSupplier.getAsDouble() // Back Speed
    );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
