package frc.robot.Sensors.Encoders;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Subsystems.WristSubsystem;

public class WristEncoder {
    public static Encoder m_WEncoder = new Encoder(4, 5, false);
    static double distanceConversion = 360 / 2048;
    static double scoringPosition = 0 * distanceConversion;
    static double storagePosition = 0 * distanceConversion;
    static double intakePosition = 0 * distanceConversion;

    public static double getWristAngle() {
        return m_WEncoder.getDistance() * 360 / 2048;
    }

    public static void setScoringPosition() {
        WristSubsystem.m_WristTalon.set(ControlMode.Position, scoringPosition);
    }

    public static void setStoragePosition() {
        WristSubsystem.m_WristTalon.set(ControlMode.Position, storagePosition);
    }

    public static void setIntakePosition() {
        WristSubsystem.m_WristTalon.set(ControlMode.Position, intakePosition);
    }
    
}