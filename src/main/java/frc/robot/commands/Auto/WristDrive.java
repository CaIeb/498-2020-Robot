/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.MoveWrist;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class WristDrive extends ParallelCommandGroup {
  /**
   * Creates a new WristDrive.
   * @param distance Inches to Drive
   * @param speed Speed to drive
   * @param position Wrist Position
   */
  public WristDrive(Wrist wrist, Drivetrain drivetrain, double distance, double speed, WristPosition position) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
    super(
      new AutoDrive(drivetrain, distance, speed),
      new MoveWrist(wrist, position)
      );
  }
}
