package frc.robot;
import frc.robot.Subsystems.*;

public class RobotContainer {
 public static void RobotPeriodic() {
    Smart_Dashboard.Smart_Dashboard_Periodic();
 }
 public static void RobotInit() {
    DriveSubsystem.driveInit();
    Smart_Dashboard.Smart_Dashboard_RobotInit();
 }
 public static void TeleOpInit() {

 }
 public static void TeleOp(){
    DriveSubsystem.driveTeleOp();
    WristSubsystem.WristTeleOp();
    Limelight.Update_Limelight_Tracking();
    Limelight.Limelight_Tracking();
    Smart_Dashboard.Smart_Dashboard_TeleOp();
 }
 public static void AutoInit() {
    Smart_Dashboard.Smart_Dashboard_AutoInit();
 }
 public static void Auto(){
    Autonomous.Auto();
 }
}