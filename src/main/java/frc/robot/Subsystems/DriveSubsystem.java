package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Smart_Dashboard;
import frc.robot.Maps.ControllerMap;
import frc.robot.Sensors.Encoders.DriveEncoders;

public final class DriveSubsystem {
    //Speed controller CAN ID
    public static int r1VictorID = 1;
    public static int r2VictorID = 2;
    public static int r3VictorID = 3;

    public static int l1VictorID = 4;
    public static int l2VictorID = 5;
    public static int l3VictorID = 6;

    public  static WPI_VictorSPX m_RVictor_1 = new WPI_VictorSPX(r1VictorID);
    public  static WPI_VictorSPX m_RVictor_2 = new WPI_VictorSPX(r2VictorID);
    public  static WPI_VictorSPX m_RVictor_3 = new WPI_VictorSPX(r3VictorID);
    //Left Drive
    public static WPI_VictorSPX m_LVictor_1 = new WPI_VictorSPX(l1VictorID);
    public static WPI_VictorSPX m_LVictor_2 = new WPI_VictorSPX(l2VictorID);
    public static WPI_VictorSPX m_LVictor_3 = new WPI_VictorSPX(l3VictorID);

    public static SpeedControllerGroup right_drive = new SpeedControllerGroup(m_RVictor_1, m_RVictor_2, m_RVictor_3);
    public static SpeedControllerGroup left_drive = new SpeedControllerGroup(m_LVictor_1, m_LVictor_2, m_LVictor_3);

    public static DifferentialDrive m_drive = new DifferentialDrive(left_drive, right_drive);

    // private static double old_Drive_Speed = 0;
    // private static double old_Steer_Speed = 0;
    // private static double drive_Speed = 0;
    // private static double steer_Speed = 0;
    // private static double rampSpeed = .1;

public static void driveInit() {

 }
 public static void driveTeleOp() {
    //double joystick_LY_Sensitivity = 1.0;
    //double joystick_RX_Sensitivity = .75;
    //double drive_Speed = ControllerMap.d_Y_Axis_L() * joystick_LY_Sensitivity);
    //double steer_Speed = ControllerMap.d_X_Axis_R() * joystick_RX_Sensitivity);
    //double motorSpeed = ControllerMap.d_Y_Axis_L() - ControllerMap.d_X_Axis_R();
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
    //  m_RVictor_1.set(motorSpeed);
    //  m_RVictor_2.set(motorSpeed);
    //  m_RVictor.set(motorSpeed);
    //  m_LVictor_1.set(-motorSpeed);
    //  m_LVictor_2.set(-motorSpeed);
    //  m_LVictor.set(-motorSpeed);

   }
}

