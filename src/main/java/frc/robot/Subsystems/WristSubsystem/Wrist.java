package frc.robot.Subsystems.WristSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Maps.ControllerMap;
import frc.robot.Subsystems.WristSubsystem.WristCommands.*;

public class Wrist{
 private static int wristTalonID  = 7;
 public static WPI_TalonSRX m_WristTalon = new WPI_TalonSRX(wristTalonID);
    public static void WristTeleOp() {
        if (ControllerMap.o_A_Button_Press) {
         WristDown.down();
        }
        else if (ControllerMap.o_X_Button_Press) {
         WristHome.home();
        }
        else if (ControllerMap.o_Y_Button_Press) {
         WristScore.score();
        }
        else {
            m_WristTalon.set(ControlMode.PercentOutput, 0);
        }
        WristEncoder.getWristAngle();
    }
}