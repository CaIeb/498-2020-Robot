package frc.robot.Subsystems.WristSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Smart_Dashboard;
import frc.robot.Maps.ControllerMap;
import frc.robot.Subsystems.WristSubsystem.WristCommands.*;

public class Wrist{
 private static int wristTalonID  = 7;
 public static WPI_TalonSRX m_WristTalon = new WPI_TalonSRX(wristTalonID);
    public static void WristTeleOp() {
        if (WristEncoder.getWristDown() == false && WristEncoder.getWristUp() == false) {

        
        if (ControllerMap.o_A_Button) {
         m_WristTalon.set(.25);
        }
        /*
        else if (ControllerMap.o_X_Button_Press) {
         WristHome.home();
        }
        */
        else if (ControllerMap.o_Y_Button) {
            m_WristTalon.set(-.25);
        }
    }
    else {
        m_WristTalon.set(0);
    }
        //WristEncoder.getWristAngle();
    }
}
