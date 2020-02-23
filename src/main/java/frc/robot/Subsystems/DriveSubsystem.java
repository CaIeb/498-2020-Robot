package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Maps.ControllerMap;

public final class DriveSubsystem {
    //Speed controller CAN ID
    public static int r1TalonID = 1;
    public static int r2VictorID = 2;
    public static int r3VictorID = 3;

    public static int l1TalonID = 4;
    public static int l2VictorID = 5;
    public static int l3VictorID = 6;

    public  static WPI_TalonSRX m_RTalon_1 = new WPI_TalonSRX(r1TalonID);
    public  static WPI_VictorSPX m_RVictor_2 = new WPI_VictorSPX(r2VictorID);
    public  static WPI_VictorSPX m_RVictor_3 = new WPI_VictorSPX(r3VictorID);
    //Left Drive
    public static WPI_TalonSRX m_LTalon_1 = new WPI_TalonSRX(l1TalonID);
    public static WPI_VictorSPX m_LVictor_2 = new WPI_VictorSPX(l2VictorID);
    public static WPI_VictorSPX m_LVictor_3 = new WPI_VictorSPX(l3VictorID);

     //public static SpeedControllerGroup right_drive = new SpeedControllerGroup(m_RTalon_1, m_RVictor_2, m_RVictor_3);
     //public static SpeedControllerGroup left_drive = new SpeedControllerGroup(m_LTalon_1, m_LVictor_2, m_LVictor_3);

     public static DifferentialDrive m_drive = new DifferentialDrive(m_LTalon_1, m_RTalon_1);

    private static double old_Drive_Speed;
    private static double old_Steer_Speed;

    
    private static double startDriveRampSpeed = .05;
    private static double startSteerRampSpeed = .01;
    private static double stopDriveRampSpeed = .3;
    private static double stopSteerRampSpeed = .3;

    private static SupplyCurrentLimitConfiguration talonConfig = new SupplyCurrentLimitConfiguration(true, 20, 21, 0);
    public static void driveInit() {
        // m_LTalon_1.enableCurrentLimit(true);
        // m_RTalon_1.enableCurrentLimit(true);
        // m_RTalon_1.configPeakCurrentLimit(20);
        // m_LTalon_1.configPeakCurrentLimit(20);
        // m_RTalon_1.configContinuousCurrentLimit(20);
        // m_LTalon_1.configContinuousCurrentLimit(20);
        // m_LTalon_1.configSupplyCurrentLimit(talonConfig);
        // m_RTalon_1.configSupplyCurrentLimit(talonConfig);
        m_LTalon_1.configContinuousCurrentLimit(20, 0);
        m_LTalon_1.configPeakCurrentLimit(0);
        m_LTalon_1.enableCurrentLimit(true);
        m_RTalon_1.configContinuousCurrentLimit(20, 0);
        m_RTalon_1.configPeakCurrentLimit(0);
        m_RTalon_1.enableCurrentLimit(true);

        m_RVictor_2.follow(m_RTalon_1);
        m_RVictor_3.follow(m_RTalon_1);
        m_LVictor_2.follow(m_LTalon_1);
        m_LVictor_3.follow(m_LTalon_1);
    }
    public static double drive_Speed() {
        double controller_Drive = ControllerMap.d_Y_Axis_L();
        double drive_Speed;
        if (controller_Drive > old_Drive_Speed && controller_Drive > 0) {
            drive_Speed = old_Drive_Speed + startDriveRampSpeed;
        }
        else if (controller_Drive > old_Drive_Speed && controller_Drive < 0) {
            drive_Speed = old_Drive_Speed + stopDriveRampSpeed;
        }
        else if (controller_Drive < old_Drive_Speed && controller_Drive < 0) {
            drive_Speed = old_Drive_Speed - startDriveRampSpeed;
        }
        else if (controller_Drive < old_Drive_Speed && controller_Drive > 0) {
            drive_Speed = old_Drive_Speed - stopDriveRampSpeed;
        }
        else {drive_Speed = 0;}
        return drive_Speed;
    }
    public static double steer_Speed() {
        double controller_Steer = ControllerMap.d_X_Axis_R();
        double steer_Speed;
        if (controller_Steer > old_Steer_Speed) {
            steer_Speed = old_Steer_Speed + startSteerRampSpeed;
        }
        else if (controller_Steer > old_Drive_Speed && controller_Steer < 0) {
            steer_Speed = old_Steer_Speed + stopSteerRampSpeed;
        }
        else if (controller_Steer < old_Steer_Speed) {
            steer_Speed = old_Steer_Speed - startSteerRampSpeed;
        }
        else if (controller_Steer < old_Drive_Speed && controller_Steer > 0) {
            steer_Speed = old_Steer_Speed - stopSteerRampSpeed;
        }
        else {steer_Speed = 0;}
        return steer_Speed;
    }
    public static void driveTeleOp() {
     //double joystick_LY_Sensitivity = 1.0;
     //double joystick_RX_Sensitivity = .75;
     //double drive_Speed = ControllerMap.d_Y_Axis_L() * joystick_LY_Sensitivity);
     //double steer_Speed = ControllerMap.d_X_Axis_R() * joystick_RX_Sensitivity);
      drive_Speed();
     double steer_Speed = ControllerMap.d_X_Axis_R();
     //double drive_Speed = drive_Speed();
     double drive_Speed = ControllerMap.d_Y_Axis_L();
     m_drive.arcadeDrive(-drive_Speed, steer_Speed);
    old_Steer_Speed = steer_Speed;
    old_Drive_Speed = drive_Speed;
     //steer_Speed = controller_Steer;
//For Individual Control\\
    //double rightmotorSpeed = ControllerMap.d_Y_Axis_L() - ControllerMap.d_X_Axis_R();
    //double leftmotorSpeed = ControllerMap.d_Y_Axis_L() + ControllerMap.d_X_Axis_R();
    //    m_RTalon_1.set(ControlMode.PercentOutput, rightmotorSpeed);
    //    m_RVictor_2.set(rightmotorSpeed);
    //    m_RVictor_3.set(rightmotorSpeed);
    //    m_LTalon_1.set(ControlMode.PercentOutput, -leftmotorSpeed);
    //    m_LVictor_2.set(-leftmotorSpeed);
    //    m_LVictor_3.set(-leftmotorSpeed);
    }
}

