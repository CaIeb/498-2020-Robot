package frc.robot.Subsystems.WristSubsystem;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Smart_Dashboard;
import frc.robot.Maps.ControllerMap;

public final class Intake {
    private static int frontVictorID = 0; //Wired #10
    private static int backVictorID = 1; //Wired #11

    public static Victor m_FrontVictor = new Victor (frontVictorID);
    public static Victor m_BackVictor = new Victor(backVictorID);
    public static void Drive() {
      if (ControllerMap.d_Bumper_R) {
       double frontRollerSpeed = -.8;
       Intake.m_FrontVictor.set(frontRollerSpeed);
      }
      else {
          Intake.m_FrontVictor.set(0);
      }
    }
    public static void IntakeTeleOp() {
     double front_Intake_Sensitivity = 1; //Value 0-1
     double front_Outake_Sensitivity = 1; //Value 0-1
     double back_Intake_Sensitivity = 1; //Value 0-1
     double back_Outake_Sensitivity = 1; //Value 0-1

     double frontRollerSpeed = ((ControllerMap.driverController.getTriggerAxis(Hand.kLeft)) * front_Intake_Sensitivity)//Intake 
     - ((ControllerMap.driverController.getTriggerAxis(Hand.kRight)) * front_Outake_Sensitivity);//Outake

     double backRollerSpeed = ((ControllerMap.driverController.getTriggerAxis(Hand.kLeft)) * back_Intake_Sensitivity) //Intake
     - ((ControllerMap.driverController.getTriggerAxis(Hand.kRight)) * back_Outake_Sensitivity);//Outake

     m_FrontVictor.set(frontRollerSpeed);
     m_BackVictor.set(backRollerSpeed);
      
     //Drive();
   }
}
