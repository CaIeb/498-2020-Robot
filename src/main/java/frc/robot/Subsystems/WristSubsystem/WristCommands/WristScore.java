package frc.robot.Subsystems.WristSubsystem.WristCommands;

import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Maps.WristPositionMap;

public class WristScore {

    private static double wristPosition = WristPositionMap.score;

    public static void score(){ 
        
        if (WristSensors.getWristAngle() > (wristPosition + WristPositionMap.toleranceAngle)) {
         Wrist.m_WristTalon.set(-WristPositionMap.speed);
        }
        else if (WristSensors.getWristAngle() < wristPosition - WristPositionMap.toleranceAngle) {
            Wrist.m_WristTalon.set(WristPositionMap.speed);
        }
        else {
         end();
        }
        /*else if (WristSensors.getWristAngle() < wristPosition + toleranceAngle && WristSensors.getWristAngle() > wristPosition - toleranceAngle) {
         Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed * toleranceSpeedFactor());
        }*/
    }
    protected static void end(){
        Wrist.m_WristTalon.set(0);
    }

}