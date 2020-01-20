package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.revrobotics.CANEncoder;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.ControllerMap;

public final class WristSubsystem {
    private static int wristTalonID  = 7;
    private static int frontVictorID = 0;
    private static int backVictorID = 1;
    public static TalonSRX m_SMax = new TalonSRX(wristTalonID);
    public static Victor m_FrontVictor = new Victor (frontVictorID);
    public static Victor m_BackVictor = new Victor(backVictorID);
    //public static Encoder m_WristEncoder = new Encoder(1, 2);
    //private static double intakeWristPosition = 1;
    //private static double scoringWristPosition = .5;
    //private static double storageWristPosition = .2;

    public static void WristTeleOp() {
     double front_Intake_Sensitivity = 1.0; //Value 0-1
     double front_Outake_Sensitivity = 1.0; //Value 0-1
     double back_Intake_Sensitivity = 1.0; //Value 0-1
     double back_Outake_Sensitivity = 1.0; //Value 0-1
     double frontRollerSpeed = ((ControllerMap.d_Trigger_R) * front_Outake_Sensitivity) 
     - ((ControllerMap.d_Trigger_L) *front_Intake_Sensitivity);

     double backRollerSpeed = ((ControllerMap.d_Trigger_R) * back_Outake_Sensitivity) 
     - ((ControllerMap.d_Trigger_L) *back_Intake_Sensitivity);

     m_FrontVictor.set(frontRollerSpeed);
     m_BackVictor.set(backRollerSpeed);

     /*if (ControllerMap.operatorController.getYButtonPressed()) {
        m_WristEncoder.setPosition(scoringWristPosition);
     }
     else if (ControllerMap.operatorController.getXButtonPressed()) {
        m_WristEncoder.setPosition(storageWristPosition);
     }
     else if (ControllerMap.operatorController.getAButtonPressed()) {
        m_WristEncoder.setPosition(intakeWristPosition);
     }
     else { }
 }*/

   }
}