package frc.robot.Autonomous.AutoCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Maps.WristPositionMap;
import frc.robot.Sensors.Encoders.*;

public class AutoWrist extends Command {
    
    public double speed;
    public double wristPosition; 

    
     /**
      * @param wristPosition 1 (Score)-- 2 (Store)-- 3 (Intake)-- Refer to Maps.WristPositionMap for double wristPosition
      * @param speed Speed to move wrist
      */
   
     public AutoWrist(double wristPosition, double speed){ 

        this.wristPosition = wristPosition; 
        this.speed = speed;

    }
    protected boolean isFinished() {
         return Math.abs(DriveEncoders.getTrueLeftDistance()) >= wristPosition;
    }
    protected void initialize() {
        DriveEncoders.m_LEncoder.reset();
    }
    protected void execute() {
        if (wristPosition == WristPositionMap.score) {
         WristEncoder.setScoringPosition();
        }
        else if (wristPosition == WristPositionMap.store) {
         WristEncoder.setStoragePosition();
        }
        else if (wristPosition == WristPositionMap.intake) {
         WristEncoder.setIntakePosition();
        }
    }
    protected void end(){
        DriveSubsystem.m_drive.arcadeDrive(0, 0);
    }
}