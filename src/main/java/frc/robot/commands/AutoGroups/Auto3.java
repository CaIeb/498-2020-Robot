/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoGroups;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.MoveWrist;
import frc.robot.commands.Auto.AutoCurve;
import frc.robot.commands.Auto.AutoDrive;
import frc.robot.commands.Auto.TimedIntake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Auto3 extends SequentialCommandGroup {
  /**
   * @param Limelight not enabled
   * @param Move Wrist
   * @param Pass Power Cells
   */
  public Auto3(Drivetrain drivetrain) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      //new MoveWrist(wrist, WristPosition.Collect),
      //new TimedIntake(intake, dumpTime, false)
      // new AutoDrive(drivetrain, 250, .75),
      // new AutoDrive(drivetrain, 250, -.75)
      new AutoCurve(drivetrain, 175, -.9, -.85)
    );
  }
}
