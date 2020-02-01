package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
//import com.revrobotics.CANEncoder;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Encoder;
import frc.robot.ControllerMap;

public final class WristSubsystem {
    private static int wristTalonID  = 7;
    private static int frontVictorID = 0;
    private static int backVictorID = 1;
    private static int wristEncoderID = 10;
    public static TalonSRX m_WristTalon = new TalonSRX(wristTalonID);
    public static Victor m_FrontVictor = new Victor (frontVictorID);
    public static Victor m_BackVictor = new Victor(backVictorID);
    public static DutyCycleEncoder m_WristEncoder = new DutyCycleEncoder(wristEncoderID);
    //private static double intakeWristPosition = 1;
    //private static double scoringWristPosition = .5;
    //private static double storageWristPosition = .2;

    public static void WristTeleOp() {
     double front_Intake_Sensitivity = 1.0; //Value 0-1
     double front_Outake_Sensitivity = 1.0; //Value 0-1
     double back_Intake_Sensitivity = 1.0; //Value 0-1
     double back_Outake_Sensitivity = 1.0; //Value 0-1

     //double wristSpeed = .5;
     double wristScorePosition = .5;
     double wristIntakePosition = 0;
     double wristStorePosition = 1;
     double encoderPosition = m_WristEncoder.get();
     //double encoderOffset = m_WristEncoder.get();
     double DistancePerRotation = 1/360;
     m_WristEncoder.setDistancePerRotation(DistancePerRotation);

     double frontRollerSpeed = ((ControllerMap.driverController.getTriggerAxis(Hand.kRight)) * front_Outake_Sensitivity) 
     - ((ControllerMap.driverController.getTriggerAxis(Hand.kLeft)) *front_Intake_Sensitivity);

     double backRollerSpeed = ((ControllerMap.driverController.getTriggerAxis(Hand.kRight)) * back_Outake_Sensitivity) 
     - ((ControllerMap.driverController.getTriggerAxis(Hand.kLeft)) *back_Intake_Sensitivity);

     m_FrontVictor.set(frontRollerSpeed);
     m_BackVictor.set(backRollerSpeed);

     if (ControllerMap.operatorController.getYButtonPressed()) {
        if(encoderPosition != wristStorePosition){
           m_WristTalon.set(ControlMode.Position, wristStorePosition);
        }
     }
     if (ControllerMap.operatorController.getXButton()) {
        if(encoderPosition != wristScorePosition) {
           m_WristTalon.set(ControlMode.Position, wristScorePosition);
        }
     }
     if (ControllerMap.operatorController.getAButton()) {
        if(encoderPosition != wristIntakePosition) {
           m_WristTalon.set(ControlMode.Position, wristIntakePosition);
        }
     }
   }
}