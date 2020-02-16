package frc.robot.Subsystems.WristSubsystem;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Smart_Dashboard;
import frc.robot.Maps.ControllerMap;

public final class Intake {
    private static int frontVictorID = 0;
    private static int backVictorID = 1;

    public static Victor m_FrontVictor = new Victor (frontVictorID);
    public static Victor m_BackVictor = new Victor(backVictorID);

    public static void IntakeTeleOp() {
     //double front_Intake_Sensitivity = 1.0; //Value 0-1
     //double front_Outake_Sensitivity = 1.0; //Value 0-1
     //double back_Intake_Sensitivity = 1.0; //Value 0-1
     //+double back_Outake_Sensitivity = 1.0; //Value 0-1

     double frontRollerSpeed = ((ControllerMap.driverController.getTriggerAxis(Hand.kLeft)) * Smart_Dashboard.smartOutakeSpeed()) 
     - ((ControllerMap.driverController.getTriggerAxis(Hand.kRight)) *Smart_Dashboard.smartIntakeSpeed());

     double backRollerSpeed = ((ControllerMap.driverController.getTriggerAxis(Hand.kLeft)) * Smart_Dashboard.smartOutakeSpeed()) 
     - ((ControllerMap.driverController.getTriggerAxis(Hand.kRight)) * Smart_Dashboard.smartIntakeSpeed());

     m_FrontVictor.set(frontRollerSpeed);
     m_BackVictor.set(backRollerSpeed);
   }
}
