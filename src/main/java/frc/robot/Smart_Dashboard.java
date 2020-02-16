package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Sensors.Gyro;
//import frc.robot.Subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import frc.robot.Sensors.Encoders.*;
import frc.robot.Subsystems.WristSubsystem.WristEncoder;

public final class Smart_Dashboard {
    public static int pdpID = 0;
    public static PowerDistributionPanel pdp = new PowerDistributionPanel(pdpID);
    public static double pdpVoltage = pdp.getVoltage();
    //Auto Selector Definitions
    public static String m_autoSelected;
    public static final SendableChooser<String> m_autochooser = new SendableChooser<>();
    public static final String testauto = "Test Auto";
    public static final String auto1 = "Auto 1";
    public static final String auto2 = "Auto 2";
    public static final String auto3 = "Auto 3";
    public static final String auto4 = "Auto 4";
    public static final String auto5 = "Auto 5";
    public static final String auto6 = "Auto 6";
    public static final String auto7 = "Auto 7";
    public static final String auto8 = "Auto 8";
    public static final String auto9 = "Auto 9";
    public static final String auto10 = "Auto 10";

    public static double smartDriveSpeed() {return SmartDashboard.getNumber("Drive Speed", .8);}
    public static double smartSteerSpeed() {return SmartDashboard.getNumber("Steer Speed", .8);}
    public static double smartWristSpeed() {return SmartDashboard.getNumber("Wrist Speed", .8);}
    public static double smartIntakeSpeed() {return SmartDashboard.getNumber("Intake Speed", .8);}
    public static double smartOutakeSpeed() {return SmartDashboard.getNumber("Outake Speed", .8);}

    public static void Smart_Dashboard_Periodic() {
        //Put general readings/updates here
        SmartDashboard.putNumber("PDP Voltage", pdpVoltage);
        SmartDashboard.putNumber("Left Encoder Distance", DriveEncoders.getTrueLeftDistance());
        SmartDashboard.putNumber("Right Encoder Distance", DriveEncoders.getTrueRightDistance());
        SmartDashboard.putNumber("Wrist Angle", WristEncoder.getWristAngle());
        SmartDashboard.putBoolean("Down Limit", WristEncoder.getWristDown());
        SmartDashboard.putBoolean("Up Limit", WristEncoder.getWristUp());
        //SmartDashboard.putNumber("Barometric Pressure", Gyro.gyro.getBarometricPressure());
        //SmartDashboard.putNumber("Gyro X", Gyro.gyro.getGyroAngleX());
        //SmartDashboard.putNumber("Gyro Y", Gyro.gyro.getGyroAngleY());
        SmartDashboard.putNumber("Drive Angle (Z)", Gyro.gyroZangle());
        smartDriveSpeed();
        smartSteerSpeed();
        smartWristSpeed();
        smartIntakeSpeed();
        smartOutakeSpeed();
    }
    public static void Smart_Dashboard_RobotInit() {
        SmartDashboard.putNumber("Drive Speed", .75);
        SmartDashboard.putNumber("Steer Speed", .75);
        SmartDashboard.putNumber("Wrist Speed", .75);
        SmartDashboard.putNumber("Intake Speed", .75);
        SmartDashboard.putNumber("Outake Speed", .75);
        //Mostly just auto selections
        m_autochooser.setDefaultOption("Auto 1", auto1);
        m_autochooser.addOption("Auto 2", auto2);
        m_autochooser.addOption("Auto 3", auto3);
        m_autochooser.addOption("Auto 4", auto4);
        m_autochooser.addOption("Auto 5", auto5);
        m_autochooser.addOption("Auto 6", auto6);
        m_autochooser.addOption("Auto 7", auto7);
        m_autochooser.addOption("Auto 8", auto8);
        m_autochooser.addOption("Auto 9", auto9);
        m_autochooser.addOption("Auto 10", auto10);
        SmartDashboard.putData("Auto choices", m_autochooser);
    }
    public static void Smart_Dashboard_AutoInit() {
        m_autoSelected = m_autochooser.getSelected();
        // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
        System.out.println("Auto selected: " + m_autoSelected);
    
    }

    public static void Smart_Dashboard_TeleOp() {

    }

}