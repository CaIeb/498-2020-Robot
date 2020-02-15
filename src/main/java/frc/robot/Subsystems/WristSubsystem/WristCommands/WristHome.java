package frc.robot.Subsystems.WristSubsystem.WristCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Subsystems.WristSubsystem.*;
import frc.robot.Smart_Dashboard;

public class WristHome {
    
 private static double speed = Smart_Dashboard.smartWristSpeed();
 private static double time = 3; 
 private static Timer timer = new Timer();
 private static double timeElapsed = timer.get();
 private static double toleranceTime = .5;
 public static double kP = time - timeElapsed;
 public static double kI = .8;
 private static double toleranceSpeedFactor() {
     return kP * kI;
 }

    public static void home(){ 
        timer.start();
     if (WristEncoder.getWristUp() == false && WristEncoder.getWristDown() == false) {
        if (timeElapsed < time - toleranceTime) {
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
        }

        else if (timeElapsed > time - toleranceTime && timeElapsed < time + toleranceTime) {
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed * toleranceSpeedFactor());
        }
        else if (timeElapsed == time) {
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