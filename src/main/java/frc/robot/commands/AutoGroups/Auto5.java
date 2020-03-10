package frc.robot.commands.AutoGroups;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.FrontRoller;
import frc.robot.commands.MoveWrist;
import frc.robot.commands.Auto.AutoCurve;
import frc.robot.commands.Auto.AutoDrive;
import frc.robot.commands.Auto.AutoFrontRoller;
import frc.robot.commands.Auto.AutoIntake;
import frc.robot.commands.Auto.TimedIntake;
import frc.robot.commands.Auto.WristDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Wrist.WristPosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Auto5 extends SequentialCommandGroup {
  /**
   * @param Limelight not enabled
   * @param Get 2 Power Cells from trench
   * @param Score 5 Power Cells
   */
  public Auto5(Drivetrain drivetrain, Wrist wrist, Intake intake) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
        new ParallelDeadlineGroup(
             new WristDrive(wrist, drivetrain, 40, .75, WristPosition.Collect),
             new AutoFrontRoller(intake, .9, true)
        ),
        new WristDrive(wrist, drivetrain, 40, -.8, WristPosition.Home),
        new AutoCurve(drivetrain, 180, -.9, .5),
        new WristDrive(wrist, drivetrain, 50, .8, WristPosition.Score),
        new WaitCommand(.25),
        new AutoIntake(intake, 1, false)
    );
  }
}
