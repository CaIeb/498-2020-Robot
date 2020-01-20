package frc.robot;
import frc.robot.Subsystems.*;

public class RobotContainer {
 public static void TeleOp(){
    DriveSubsystem.driveTeleOp();
    WristSubsystem.WristTeleOp();
    Limelight.Update_Limelight_Tracking();
    Limelight.Limelight_Tracking();
 }
 public static void Auto(){

 }
}