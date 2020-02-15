package frc.robot.Subsystems.WristSubsystem.WristCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Smart_Dashboard;
import frc.robot.Maps.WristPositionMap;

public class WristDown {

    private static double speed = Smart_Dashboard.smartWristSpeed();
    private static double wristPosition = WristPositionMap.down;
    private static double toleranceAngle = 20;

    public static double kP = wristPosition - WristEncoder.getWristAngle();
    public static double kI = .2;
    private static double toleranceSpeedFactor() {
        return kP * kI;
    }
    

    public static void down(){ 
        if (WristEncoder.getWristAngle() > (wristPosition + toleranceAngle) || WristEncoder.getWristAngle() < wristPosition - toleranceAngle){
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
        }

        else if (WristEncoder.getWristAngle() < wristPosition + toleranceAngle && WristEncoder.getWristAngle() > wristPosition - toleranceAngle) {
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed * toleranceSpeedFactor());
        }
        else {
         end();
        }
         /*
        else if (WristEncoder.getWristAngle() < wristPosition - toleranceAngle) {
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
        }
        
        else if (WristEncoder.getWristAngle() > wristPosition && WristEncoder.getWristAngle() < wristPosition + toleranceAngle){
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, -speed * toleranceSpeedFactor());
        }
        */
    }
    protected static void end(){
        Wrist.m_WristTalon.set(ControlMode.PercentOutput, 0);
    }
    /*protected boolean isFinished() {
         return Math.abs(WristEncoder.getWristAngle()) >= wristPosition;
    }
    protected void initialize() {
        
    }
    protected void execute() {
        if (WristEncoder.getWristAngle() > wristPosition){
        Wrist.m_WristTalon.set(ControlMode.PercentOutput, -speed);
        }
        else if (WristEncoder.getWristAngle() < wristPosition) {
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
        }
        else {end();}
    }
    */
    
}