package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Smart_Dashboard;
import frc.robot.Maps.ControllerMap;
import frc.robot.Sensors.Encoders.DriveEncoders;

public final class DriveSubsystem {
    //Speed controller CAN ID
    public static int r0VictorID = 4;
    public static int r1VictorID = 2;
    public static int r2VictorID = 3;

    public static int l1VictorID = 1;
    public static int l2VictorID = 5;
    public static int l3VictorID = 6;

    public  static WPI_VictorSPX m_RVictorFollow_0 = new WPI_VictorSPX(r1VictorID);
    public  static WPI_VictorSPX m_RVictorFollow_1 = new WPI_VictorSPX(r2VictorID);
    public  static WPI_VictorSPX m_RVictor = new WPI_VictorSPX(r0VictorID);
    //Left Drive
    public static WPI_VictorSPX m_LVictorFollow_3 = new WPI_VictorSPX(l1VictorID);
    public static WPI_VictorSPX m_LVictorFollow_4 = new WPI_VictorSPX(l2VictorID);
    public static WPI_VictorSPX m_LVictor = new WPI_VictorSPX(l3VictorID);

    public static DifferentialDrive m_drive = new DifferentialDrive(m_LVictor, m_RVictor);

    private static double old_Drive_Speed = 0;
    private static double old_Steer_Speed = 0;
    private static double drive_Speed = 0;
    private static double steer_Speed = 0;
    private static double rampSpeed = .1;

public static void driveInit() {
    //Right Drive SpeedControllerGroup
    m_RVictorFollow_0.follow(m_RVictor);
    m_RVictorFollow_1.follow(m_RVictor);
    //Left Drive SpeedControllerGroup
    m_LVictorFollow_3.follow(m_LVictor);
    m_LVictorFollow_4.follow(m_LVictor);
    //Configure Encoders
    DriveEncoders.configureEncoders();
 }
 public static void driveTeleOp() {
    //double joystick_LY_Sensitivity = 1.0;
    //double joystick_RX_Sensitivity = .75;
    //double drive_Speed = ControllerMap.d_Y_Axis_L() * joystick_LY_Sensitivity);
    //double steer_Speed = ControllerMap.d_X_Axis_R() * joystick_RX_Sensitivity);
    double controller_Drive = ControllerMap.d_Y_Axis_L() * Smart_Dashboard.smartDriveSpeed();
    double controller_Steer = ControllerMap.d_X_Axis_R() * Smart_Dashboard.smartSteerSpeed();
    //m_drive.arcadeDrive(drive_Speed, steer_Speed);

    // if (controller_Drive > old_Drive_Speed) {
    //     drive_Speed = old_Drive_Speed + rampSpeed;
    //     //steer_Speed = controller_Steer;
    // }
    // else if (controller_Drive < old_Drive_Speed) {
    //     drive_Speed = old_Drive_Speed - rampSpeed;
    //     //steer_Speed = controller_Steer;
    // }
    // if (controller_Steer > old_Steer_Speed) {
    //     //drive_Speed = controller_Drive;
    //     steer_Speed = old_Steer_Speed + rampSpeed;
    // }
    // else if (controller_Steer < old_Steer_Speed) {
    //     //drive_Speed = controller_Drive;
    //     steer_Speed = old_Steer_Speed - rampSpeed;
    // }
    // else {
    //     steer_Speed = controller_Steer;
    // }
    
    m_drive.arcadeDrive(-controller_Drive, controller_Steer);
    //steer_Speed = controller_Steer;
    
   }
}

