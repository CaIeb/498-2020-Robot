package frc.robot.Subsystems.WristSubsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import frc.robot.Maps.ControllerMap;
import frc.robot.Subsystems.WristSubsystem.WristCommands.*;

public class Wrist{
 private static int wristTalonID  = 7;
 public static WPI_TalonSRX m_WristTalon = new WPI_TalonSRX(wristTalonID);
    public static void WristTeleOp() {

        if (ControllerMap.operatorController.getBumper(Hand.kRight)) {
         WristCollect.collect();
        }
        else if (ControllerMap.operatorController.getBumper(Hand.kLeft)) {
         WristHome.home();
        }
        else if (ControllerMap.operatorController.getAButton()) {
         WristScore.score();
        }
        else if (ControllerMap.operatorController.getYButton()) {
         WristLoad.load();
        }
        else {
         m_WristTalon.set(0);
        }
         WristSensors.getWristAngle();
        }   
        //m_WristTalon.set(ControllerMap.o_Y_Axis_L() * Smart_Dashboard.smartWristSpeed());
    
}

/*public class Wrist{
 private static int wristTalonID  = 7;
 public static WPI_TalonSRX m_WristTalon = new WPI_TalonSRX(wristTalonID);
    public static void WristTeleOp() {

            double speed = ControllerMap.o_Y_Axis_R() * Smart_Dashboard.smartWristSpeed();
            if (WristEncoder.getWristFree()) {
            m_WristTalon.set(speed);
            }
            else if (WristEncoder.getWristDown() == false){
                m_WristTalon.set(Math.abs(speed));
            }
            else if (WristEncoder.getWristUp() == false) {
                m_WristTalon.set(-Math.abs(speed));
            }
            else {
                m_WristTalon.set(0);
            }
           }
           
    }
    */

