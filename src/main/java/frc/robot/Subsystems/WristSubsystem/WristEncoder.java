package frc.robot.Subsystems.WristSubsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class WristEncoder {
    public static Potentiometer m_WristPot = new AnalogPotentiometer(3);

    //private static double angleToTickConversion = 2048 / 360;
    private static double tickToAngleConversion = 360 / 1024;

    public static double getWristAngle() {
        //m_WEncoder.setDistancePerPulse(360/2048);
        return (m_WristPot.get() * (tickToAngleConversion));
    }
}
    