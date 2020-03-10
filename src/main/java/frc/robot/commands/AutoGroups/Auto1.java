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
import frc.robot.commands.Auto.AutoCurve;
import frc.robot.commands.Auto.AutoDrive;
import frc.robot.commands.Auto.AutoIntake;
import frc.robot.commands.Auto.AutoIntakeOnly;
import frc.robot.commands.Auto.LimelightAdjust;
import frc.robot.commands.Auto.LimelightAlign;
import frc.robot.commands.Auto.WristDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Auto1 extends SequentialCommandGroup {

/**
 * @param Limelight enabled
 * @param Score
 * @param Drive through Trench Run,
 * @param Score
 */
  public Auto1(Drivetrain drivetrain, Wrist wrist, Intake intake) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
     super(
       new MoveWrist(wrist, WristPosition.Home),
       new WaitCommand(.75),
       new LimelightAlign(drivetrain),
       new WristDrive(wrist, drivetrain, 28, .75, WristPosition.Score),
       new WaitCommand(.3),
       new AutoIntakeOnly(intake, 1, 1, false),
       new WristDrive(wrist, drivetrain, 32, -.75, WristPosition.Home),
       new ParallelCommandGroup(
          new AutoCurve(drivetrain, 160, -.9, -.9),
          new MoveWrist(wrist, WristPosition.Collect)
      ),
      new ParallelDeadlineGroup(
          new AutoDrive(drivetrain, 120, .75),
          new AutoIntake(intake, 1, true)
      ),
      new AutoDrive(drivetrain, 120, -.75),
      new ParallelCommandGroup(
        new AutoCurve(drivetrain, 125, -.65, -.85),
        new MoveWrist(wrist, WristPosition.Score)
     ),
      new LimelightAdjust(drivetrain),
      new LimelightAlign(drivetrain),
      new WristDrive(wrist, drivetrain, 28, .75, WristPosition.Score),
      new WaitCommand(.3),
      new AutoIntakeOnly(intake, 2, 1, false)
     );
  }
}
