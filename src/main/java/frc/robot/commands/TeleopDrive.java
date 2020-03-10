package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
  private final Drivetrain drivetrain;
  private final DoubleSupplier speed;
  private final DoubleSupplier rotation;

  public TeleopDrive(Drivetrain drivetrain, DoubleSupplier speed, DoubleSupplier rotation) {
    this.drivetrain = drivetrain;
    this.speed = speed;
    this.rotation = rotation;
    addRequirements(this.drivetrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    drivetrain.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble() * .85);
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }
}