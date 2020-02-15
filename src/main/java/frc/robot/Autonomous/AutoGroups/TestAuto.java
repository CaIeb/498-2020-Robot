package frc.robot.Autonomous.AutoGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Autonomous.AutoCommands.*;

public class TestAuto extends CommandGroup {
    public TestAuto() {
        addSequential(new TimedTurn(3, 1));
        addSequential(new TimedTurn(3, -1));
        addSequential(new AutoTurn(90, 1));
        addSequential(new AutoTurn(90, -1));
    }
}