package frc.robot.Subsystems.WristSubsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class WristSensors {
    public static Potentiometer m_WristPot = new AnalogPotentiometer(0);
    private static int wristDownChannel = 4;
    private static int wristUpChannel = 5;
    public static DigitalInput wristDown = new DigitalInput(wristDownChannel);
    public static DigitalInput wristUp = new DigitalInput(wristUpChannel);
    //private static double angleToTickConversion = 2048 / 360;
    
    private static double tickToAngleConversion = 90 / .35;

    public static boolean getWristUp() { //false = activated
        return wristUp.get();
    }
    public static boolean getWristDown() {
        return wristDown.get();
    }
    public static boolean getWristFree() {
        return (getWristUp() && getWristDown());
    }
    public static double getWristAngle() {
        //m_WEncoder.setDistancePerPulse(360/2048);
        double wristAngle = m_WristPot.get() * (tickToAngleConversion);
        return m_WristPot.get();
    }
}
    