package frc.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Smart_Dashboard;
import frc.robot.Autonomous.AutoGroups.*;

public final class Autonomous{
    static CommandGroup AutoCommandGroup;

    public static void Auto() {
        switch (Smart_Dashboard.m_autoSelected) {
            case Smart_Dashboard.testauto:
             AutoCommandGroup = new TestAuto();
             AutoCommandGroup.start();
            break;

            case Smart_Dashboard.auto1:
             AutoCommandGroup = new Auto1();
             AutoCommandGroup.start();
            break;
            
            case Smart_Dashboard.auto2:
             
            break;
        }
    }
}