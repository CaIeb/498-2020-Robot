package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.ControllerMap;

public final class DriveSubsystem {
    //Speed controller CAN ID
    public static int r1VictorID = 0;
    public static int r2VictorID = 1;
    public static int rTalonID = 2;
    public static int l1VictorID = 3;
    public static int l2VictorID = 4;
    public static int lTalonID = 5;

    public  static WPI_VictorSPX m_RVictorFollow_0 = new WPI_VictorSPX(r1VictorID);
    public  static WPI_VictorSPX m_RVictorFollow_1 = new WPI_VictorSPX(r2VictorID);
    public  static WPI_TalonSRX m_RTalon = new WPI_TalonSRX(rTalonID);
    //Left Drive
    public static WPI_VictorSPX m_LVictorFollow_3 = new WPI_VictorSPX(l1VictorID);
    public static WPI_VictorSPX m_LVictorFollow_4 = new WPI_VictorSPX(l2VictorID);
    public static WPI_TalonSRX m_LTalon = new WPI_TalonSRX(lTalonID);
    public static DifferentialDrive m_drive = new DifferentialDrive(m_LTalon, m_RTalon);
    //Encoder Information
    public static Encoder m_REncoder = new Encoder(1, 2, false, CounterBase.EncodingType.k4X);
    public static Encoder m_LEncoder = new Encoder(3, 4, false, CounterBase.EncodingType.k4X);


 public static void driveInit() {
    //Right Drive SpeedControllerGroup
    m_RVictorFollow_0.follow(m_RTalon);
    m_RVictorFollow_1.follow(m_RTalon);
    //Left Drive SpeedControllerGroup
    m_LVictorFollow_3.follow(m_LTalon);
    m_LVictorFollow_4.follow(m_LTalon);
 }
 public static final void driveTeleOp() {
    double joystick_LY_Sensitivity = 1.0;
    double joystick_RX_Sensitivity = .75;
    double drive_Speed = (ControllerMap.d_Y_Axis_L * joystick_LY_Sensitivity);
    double steer_Speed = (ControllerMap.d_X_Axis_R * joystick_RX_Sensitivity);
    m_drive.arcadeDrive(drive_Speed, steer_Speed);
 }
 public static void resetEncoders() {
     m_REncoder.reset();
     m_LEncoder.reset();
 }
}

