
package frc.robot.Sensors;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Maps.ControllerMap;

public class Limelight {
  private static boolean m_LimelightHasValidTarget = false;
  private static double m_LimelightDriveCommand = 0.0;
  private static double m_LimelightSteerCommand = 0.0;
 public static void LimelightInit() {
   int standardStream = 0;
   NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(standardStream);
 }
 public static void LimelightTeleOp() {
    Update_Limelight_Tracking();
    Limelight_Load();
    Limelight_Score();
 }
 public static void SwitchLimelightScore() {
   int scorePipeline = 1;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(scorePipeline);
  }
 public static void SwitchLimelightLoad() {
   int loadPipeline = 0;
   NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(loadPipeline);
  }
 public static void Limelight_Score() {

   boolean buttonDetected = ControllerMap.driverController.getBumper(Hand.kRight);

   SwitchLimelightScore();

   if (buttonDetected && m_LimelightHasValidTarget) {
     DriveSubsystem.m_drive.arcadeDrive(m_LimelightDriveCommand,m_LimelightSteerCommand);
        
    }
   else {
     DriveSubsystem.driveTeleOp();
    }
  }

  public static void Limelight_Load() {
    //double steer = m_Controller.getX(Hand.kRight);
    //double drive = -m_Controller.getY(Hand.kLeft);
    boolean buttonDetected = ControllerMap.driverController.getBumper(Hand.kLeft);

   SwitchLimelightLoad();

   if (buttonDetected && m_LimelightHasValidTarget) {
     DriveSubsystem.m_drive.arcadeDrive(m_LimelightDriveCommand,m_LimelightSteerCommand);
        
    }
   else {
     DriveSubsystem.driveTeleOp();
    }
  }

 public static void Update_Limelight_Tracking()
   {
      final double Steer_K = 0.03;                
      final double Drive_K = 0.26;                   
      final double Target_Area = 13.0;        
      final double Max_Drive = 0.7;                   

      double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
      double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
      //double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
      double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

      if (tv < 1.0)
      {
        m_LimelightHasValidTarget = false;
        m_LimelightDriveCommand = 0.0;
        m_LimelightSteerCommand = 0.0;
        return;
      }

      m_LimelightHasValidTarget = true;

      // Start with proportional steering
      double steer_cmd = tx * Steer_K;
      m_LimelightSteerCommand = steer_cmd;

      // try to drive forward until the target area reaches our desired area
      double drive_cmd = (Target_Area - ta) * Drive_K;

      // don't let the robot drive too fast into the goal
      if (drive_cmd > Max_Drive)
      {
        drive_cmd = Max_Drive;
      }
      m_LimelightDriveCommand = drive_cmd;
}
}