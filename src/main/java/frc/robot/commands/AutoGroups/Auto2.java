/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.MoveWrist;
import frc.robot.commands.Auto.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Auto2 extends SequentialCommandGroup {
  /**
  * @param Limelight not enabled
  * @param Score
  * @param Drive through Trench Run,
  * @param Score
  */
  public Auto2(Drivetrain drivetrain, Wrist wrist, Intake intake) {
    super(
      new WristDrive(wrist, drivetrain, 90, .9, WristPosition.Score),
      new WaitCommand(.2),
      new AutoIntakeOnly(intake, 1, 1, false),
      //new WristDrive(wrist, drivetrain, 32, -.9, WristPosition.Home),
      new AutoDrive(drivetrain, -10, -.9),
      new ParallelCommandGroup(
        new AutoCurve(drivetrain, 175, -.9, -.85),
          new MoveWrist(wrist, WristPosition.Collect)
      ),
      new ParallelDeadlineGroup(
          new AutoDrive(drivetrain, 360, .75),
          new AutoIntake(intake, 1, true)
      ),
      new AutoDrive(drivetrain, 330, -.9),
       new ParallelCommandGroup(
         new AutoCurve(drivetrain, 160, -.9, -.7),
         new MoveWrist(wrist, WristPosition.Score)
       ),
      //new AutoDrive(drivetrain, 40, .75),
      new WristDrive(wrist, drivetrain, 50, .75, WristPosition.Score),
      new WaitCommand(.2),
      new AutoIntakeOnly(intake, 2, 1, false)
    );
  }
}
