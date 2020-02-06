package frc.robot.Sensors.Encoders;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Subsystems.*;

public class DriveEncoders {

    public static Encoder m_REncoder = new Encoder(0, 1, true);
    public static Encoder m_LEncoder = new Encoder(2, 3, true);

    public static double getTrueLeftDistance() {
        return ((m_LEncoder.getDistance()) * (Math.PI*5/2048));
    }
    public static double getTrueRightDistance() {
        return ((m_REncoder.getDistance()) * (Math.PI*5/2048));
    }
    public static void balanceEncoders() {
        if (m_LEncoder.getDistance() >= m_REncoder.getDistance()) {
            DriveSubsystem.m_drive.tankDrive(0, .25);
        }
        else if (m_LEncoder.getDistance() <= m_REncoder.getDistance()) {
            DriveSubsystem.m_drive.tankDrive(.25, 0);
        }
    }
    public static double getTrueDistance() {
        balanceEncoders();
        return (getTrueLeftDistance() + getTrueRightDistance())/2;
    }
    public static void resetEncoders() {
        m_REncoder.reset();
        m_LEncoder.reset();
    }
}