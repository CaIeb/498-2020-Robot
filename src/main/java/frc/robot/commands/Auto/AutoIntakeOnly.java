/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoIntakeOnly extends ParallelDeadlineGroup {
  /**
   * Creates a new AutoIntakeOnly.
   */
  public AutoIntakeOnly(Intake intake, double timeToRun, double time, boolean isIntaking) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new WaitCommand(timeToRun),
        new AutoIntake(intake, time, isIntaking)
    );
  }
}
