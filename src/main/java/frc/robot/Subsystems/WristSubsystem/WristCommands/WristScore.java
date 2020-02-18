package frc.robot.Subsystems.WristSubsystem.WristCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Smart_Dashboard;
import frc.robot.Maps.WristPositionMap;

public class WristScore {

    private static double speed = Smart_Dashboard.smartWristSpeed();
    private static double wristPosition = WristPositionMap.score;
    private static double toleranceAngle = .05;

    public static double kP = wristPosition - WristSensors.getWristAngle();
    public static double kI = 16;
    private static double toleranceSpeedFactor() {
        return kP * kI;
    }
    public static void score(){ 
        
        if (WristSensors.getWristAngle() > (wristPosition + toleranceAngle)) {
         Wrist.m_WristTalon.set(-speed);
        }
        else if (WristSensors.getWristAngle() < wristPosition - toleranceAngle) {
            Wrist.m_WristTalon.set(speed);
        }
        /*else if (WristSensors.getWristAngle() < wristPosition + toleranceAngle && WristSensors.getWristAngle() > wristPosition - toleranceAngle) {
         Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed * toleranceSpeedFactor());
        }*/
        else {
         end();
        }

    }
    protected static void end(){
        Wrist.m_WristTalon.set(0);
    }

}