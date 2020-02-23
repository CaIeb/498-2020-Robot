package frc.robot.Subsystems.ControlPanel;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

public class ControlPanelSensors {
 private static int upLimitChannel = 6;
 private static int downLimitChannel = 7;
 private static int motorID = 10;
 public static DigitalInput controlPanelLimitUp = new DigitalInput(upLimitChannel);
 public static DigitalInput controlPanelLimitDown = new DigitalInput(downLimitChannel);
 public static WPI_TalonSRX controlPanelMotor = new WPI_TalonSRX(motorID);

    public static boolean getControlPanelUp() {
        return controlPanelLimitUp.get();
    }
    public static boolean getControlPanelDown() {
        return controlPanelLimitDown.get();
    }
}