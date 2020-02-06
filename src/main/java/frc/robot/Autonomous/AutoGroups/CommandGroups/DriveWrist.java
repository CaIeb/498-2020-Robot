package frc.robot.Autonomous.AutoGroups.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Autonomous.AutoCommands.*;

public class DriveWrist extends CommandGroup {

    public double distance;
    public double distanceSpeed;
    public double wristPosition;
    public double wristSpeed;
    /** 
     * @param distance Distance in Inches to travel
     * @param distanceSpeed Speed to travel distance
     * @param wristPosition 1(Score)-- 2(Store)-- 3(Intake)-- Refer to Maps.WristPositionMap for wristPosition variables
     * @param wristSpeed Speed to move wrist
    */
    public DriveWrist(double distance, double distanceSpeed, double wristPosition, double wristSpeed) {
        this.distance = distance;
        this.distanceSpeed = distanceSpeed;
        this.wristPosition = wristPosition;
        this.wristSpeed = wristSpeed;
        addParallel(new AutoDrive(distance, distanceSpeed));
        addParallel(new AutoWrist(wristPosition, wristSpeed));
    }

}