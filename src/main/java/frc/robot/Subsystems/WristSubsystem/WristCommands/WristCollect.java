package frc.robot.Subsystems.WristSubsystem.WristCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Smart_Dashboard;
import frc.robot.Maps.WristPositionMap;

public class WristCollect {

    private static double speed = Smart_Dashboard.smartWristSpeed();
    private static double wristPosition = WristPositionMap.collect;
    private static double toleranceAngle = .05;

    public static double kP = wristPosition - WristSensors.getWristAngle();
    public static double kI = 16;
    private static double toleranceSpeedFactor() {
        return kP * kI;
    }
    public static void collect(){ 
        if(WristSensors.getWristDown() == true) {
            if (WristSensors.getWristAngle() > (wristPosition /*+ toleranceAngle*/)) {
                Wrist.m_WristTalon.set(ControlMode.PercentOutput, -speed);
               }
               else if (WristSensors.getWristAngle() < wristPosition) {
                   Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
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
        else {
            end();
        }

    }
    protected static void end(){
        Wrist.m_WristTalon.set(ControlMode.PercentOutput, 0);
    }

}