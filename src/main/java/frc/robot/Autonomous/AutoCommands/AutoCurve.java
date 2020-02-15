package frc.robot.Autonomous.AutoCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Sensors.Gyro;
import frc.robot.Sensors.Encoders.DriveEncoders;

public class AutoCurve extends Command {
    
    public double turnAngle;
    public double turnSpeed;
    public double distance;
    public double distanceSpeed;
    /** 
     * @param turnAngle Angle to turn
     * @param turnSpeed Speed to turn
     * @param distance Distance in Inches to travel
     * @param distanceSpeed Speed to travel distance
    */
    public AutoCurve(double turnAngle, double turnSpeed, double distance, double distanceSpeed){
        this.turnAngle = turnAngle;
        this.turnSpeed = turnSpeed;
        this.distance  = distance;
        this.distanceSpeed = distanceSpeed;
    }
    protected boolean isFinished() {
        return Math.abs(Gyro.gyroZangle()) >= turnAngle && Math.abs(DriveEncoders.getTrueLeftDistance()) >= distance;
    }
    protected void initialize() {
        Gyro.gyro.reset();
    }
    protected void execute() {
        DriveSubsystem.m_drive.arcadeDrive(distanceSpeed, turnSpeed);
    }
    protected void end(){
        DriveSubsystem.m_drive.arcadeDrive(0, 0);
    }
}