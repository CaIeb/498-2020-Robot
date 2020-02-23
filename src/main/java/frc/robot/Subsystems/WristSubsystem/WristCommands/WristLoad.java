package frc.robot.Subsystems.WristSubsystem.WristCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Maps.WristPositionMap;

public class WristLoad {

    private static double wristPosition = WristPositionMap.load;

    public static void load(){ 
        if (WristSensors.getWristAngle() > (wristPosition + WristPositionMap.toleranceAngle)) {
            Wrist.m_WristTalon.set(-WristPositionMap.speed);
           }
           else if (WristSensors.getWristAngle() < wristPosition - WristPositionMap.toleranceAngle) {
               Wrist.m_WristTalon.set(WristPositionMap.speed);
           }
           else {
            end();
           }
        // if (WristSensors.getWristAngle() > (wristPosition + toleranceAngle) || WristSensors.getWristAngle() < wristPosition - toleranceAngle){
        //  Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
        // }
        // else if (WristSensors.getWristAngle() < wristPosition + toleranceAngle && WristSensors.getWristAngle() > wristPosition - toleranceAngle) {
        //  Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed * toleranceSpeedFactor());
        // }
        
    }
    protected static void end(){
        Wrist.m_WristTalon.set(ControlMode.PercentOutput, 0);
    }

}