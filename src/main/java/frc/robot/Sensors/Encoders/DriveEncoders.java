package frc.robot.Sensors.Encoders;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Subsystems.*;

public class DriveEncoders {
    public static double cpr = 2048;
    public static  double wheelCircumference = Math.PI * 5;
    public static double trueDistanceConversion = wheelCircumference / cpr;

    public static void configureEncoders() { //for MagEncoders
        //DriveSubsystem.m_LTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        //DriveSubsystem.m_RTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    }
    
    static boolean reversed = true;
    static boolean notReversed = false;
    
    public static Encoder m_REncoder = new Encoder(0, 1, reversed);
    public static Encoder m_LEncoder = new Encoder(2, 3, notReversed);

    public static double getTrueLeftDistance() {
        return (m_LEncoder.getDistance() * (trueDistanceConversion));
        //return (Smart_Dashboard.smartWristSpeed());
    }
    public static double getTrueRightDistance() {
        return (m_REncoder.getDistance() * (trueDistanceConversion));
        //return (Smart_Dashboard.smartWristSpeed());
    }
    public static void balanceEncoders() {
        if (getTrueLeftDistance() >= getTrueRightDistance()) {
            DriveSubsystem.m_drive.tankDrive(0, .25);
        }
        else if (getTrueLeftDistance() <= getTrueRightDistance()) {
            DriveSubsystem.m_drive.tankDrive(.25, 0);
        }
    }
    public static double setTrueDistance() {
        balanceEncoders();
        return (getTrueLeftDistance() + getTrueRightDistance())/2;
    }
    
    public static void resetEncoders() {
        m_REncoder.reset();
        m_LEncoder.reset();
    }
    
}