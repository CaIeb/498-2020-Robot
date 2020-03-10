/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoGroups;

import java.util.function.DoubleSupplier;

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
public class Auto4 extends SequentialCommandGroup {
  /**
   * @param Limelight enabled
   * @param Pass to Alliance Partners
   * @param Drive through Trench Run
   * @param Score in Lower Port
   */
  public Auto4(Drivetrain drivetrain, Wrist wrist, Intake intake, DoubleSupplier dumpTime) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
        new MoveWrist(wrist, WristPosition.Collect),
        new WaitCommand(.3),
        new TimedIntake(intake, dumpTime, false),
        new ParallelCommandGroup(
            new AutoTurn(drivetrain, 90, -.8),
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
