package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimberConstants;
import frc.robot.subsystems.Climber;

public class ClimberDown extends CommandBase {
  private final Climber climber;
  private final double SPEED = .95;
  /**
   * Creates a new ClimberUp.
   */
  public ClimberDown(Climber climber) {
    this.climber = climber;
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climber.set(-SPEED);
    SmartDashboard.putNumber("ClimberValue", climber.getEncoderValue());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      climber.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return climber.getEncoderValue() <= ClimberConstants.downEncoderValue;
  }
}