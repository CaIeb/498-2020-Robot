/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class AutoIntake extends CommandBase {
  private final Intake intake;
  private final double time;
  private final boolean isIntaking;
  private final Timer timer = new Timer();
  private final double TIMETOSPEEDRATIO = 1 / 1;
  /**
   * Creates a new AutoIntake.
   */
  public AutoIntake(Intake intake, double time, boolean isIntaking) {
    this.intake = intake;
    this.time = time;
    this.isIntaking = isIntaking;
    addRequirements(intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(isIntaking == true) {
      intake.set(TIMETOSPEEDRATIO / time, TIMETOSPEEDRATIO / time);
      }
      else {
      intake.set(-(TIMETOSPEEDRATIO / time), -(TIMETOSPEEDRATIO / time));
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
    return false;
  }
}
