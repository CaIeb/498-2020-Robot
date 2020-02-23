package frc.robot.Subsystems.WristSubsystem.WristCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Maps.WristPositionMap;

public class WristHome {

    private static double wristPosition = WristPositionMap.home;

    public static void home() { 
        if(WristSensors.getWristUp() == true) {
            if (WristSensors.getWristAngle() > (wristPosition + WristPositionMap.toleranceAngle)) {
                Wrist.m_WristTalon.set(-WristPositionMap.speed);
               }
               else if (WristSensors.getWristAngle() < wristPosition - WristPositionMap.toleranceAngle) {
                   Wrist.m_WristTalon.set(WristPositionMap.speed);
               }
               else {
                end();
               }
            }
            // if (WristSensors.getWristAngle() > (wristPosition + toleranceAngle) || WristSensors.getWristAngle() < wristPosition - toleranceAngle){
            //  Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
            // }
            // else if (WristSensors.getWristAngle() < wristPosition + toleranceAngle && WristSensors.getWristAngle() > wristPosition - toleranceAngle) {
            //  Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed * toleranceSpeedFactor());
            // }
        
        else {
         end();
        }

    }
    protected static void end(){
     Wrist.m_WristTalon.set(ControlMode.PercentOutput, 0);
    }

}