package frc.robot.Subsystems.WristSubsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class WristEncoder {
    public static Potentiometer m_WristPot = new AnalogPotentiometer(0);
    private static int wristDownChannel = 4;
    private static int wristUpChannel = 5;
    public static DigitalInput wristDown = new DigitalInput(wristDownChannel);
    public static DigitalInput wristUp = new DigitalInput(wristUpChannel);
    //private static double angleToTickConversion = 2048 / 360;
    private static double tickToAngleConversion = 360 / 1024;

    public static boolean getWristUp() {
        return wristUp.get();
    }
    public static boolean getWristDown() {
        return wristDown.get();
    }
    public static double getWristAngle() {
        //m_WEncoder.setDistancePerPulse(360/2048);
        return (m_WristPot.get() * (tickToAngleConversion));
    }
}
    