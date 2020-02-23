package frc.robot.Subsystems.WristSubsystem.WristCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Maps.WristPositionMap;

public class WristUp {

    private static double wristPosition = WristPositionMap.home;

    public static void up() { 
        if(WristSensors.getWristUp() == true) { //not activated
            if (WristSensors.getWristAngle() > (wristPosition + WristPositionMap.toleranceAngle)) {
             Wrist.m_WristTalon.set(-WristPositionMap.speed);
            }
            else if (WristSensors.getWristAngle() < wristPosition - WristPositionMap.toleranceAngle) {
             Wrist.m_WristTalon.set(WristPositionMap.speed);
            }
            else {
             end();
            }
            Intake.m_FrontVictor.set(-.8);
        }
        else {
         end();
        }

    }
    protected static void end(){
     Wrist.m_WristTalon.set(ControlMode.PercentOutput, 0);
    }

}