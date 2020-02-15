package frc.robot.Autonomous.AutoCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.WristSubsystem.*;

public class AutoWrist extends Command {

 public double wristPosition;
 double speed = .9;
    
    /**
    * @param wristPosition 1 (Score)-- 2 (Store)-- 3 (Intake)-- Refer to Maps.WristPositionMap for double wristPosition
    */
   
    public AutoWrist(double wristPosition){ 

        this.wristPosition = wristPosition; 

    }

    protected void initialize() {

    }
    protected void execute() {
     double toleranceAngle = 20;

     double kP = wristPosition - WristEncoder.getWristAngle();
     double kI = .2;
     double toleranceSpeedFactor = kP * kI;

        if (WristEncoder.getWristAngle() > (wristPosition + toleranceAngle) || WristEncoder.getWristAngle() < wristPosition - toleranceAngle){
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed);
        }

        else if (WristEncoder.getWristAngle() < (wristPosition + toleranceAngle) && WristEncoder.getWristAngle() > (wristPosition - toleranceAngle)) {
            Wrist.m_WristTalon.set(ControlMode.PercentOutput, speed * toleranceSpeedFactor);
        }
        else {
         end();
        }
    }
    protected boolean isFinished() {
        return WristEncoder.getWristAngle() == wristPosition;
    }
    protected void end(){
        DriveSubsystem.m_drive.arcadeDrive(0, 0);
    }
}