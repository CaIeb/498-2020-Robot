package frc.robot.Autonomous.AutoGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Autonomous.AutoCommands.*;
import frc.robot.Autonomous.AutoGroups.CommandGroups.*;

public class Auto1 extends CommandGroup {
    public Auto1() {
        addSequential(new AutoGyro(90, .8));
        addSequential(new AutoGyro(90, -.8));
        addSequential(new AutoDrive(36, .8));
        addSequential(new AutoDrive(36, -.8));
        addSequential(new DriveWrist(48, .8, 0, .8));
    }
}