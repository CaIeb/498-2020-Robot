package frc.robot.Autonomous.AutoCommands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Sensors.Encoders.DriveEncoders;

public class AutoDrive extends Command {
    
    public double distance;
    public double speed;
    /** 
     * @param distance Distance in Inches to travel
     * @param speed Speed to travel distance
    */
    public AutoDrive(double distance, double speed){

        this.distance = distance; 
        this.speed = speed;
        /*
        double rightdistance = distance;
        double leftdistance = distance;

        double kp = (distance - DriveEncoders.getTrueDistance());
        rightdistance = rightdistance - kp;
        leftdistance = leftdistance + kp;
        */
    }
    protected boolean isFinished() {
         return Math.abs(DriveEncoders.getTrueLeftDistance()) >= distance;
    }
    protected void initialize() {
        DriveEncoders.m_LEncoder.reset();
    }
    protected void execute() {
        DriveSubsystem.m_drive.arcadeDrive(speed, 0);
        DriveEncoders.balanceEncoders();
    }
    protected void end(){
        DriveSubsystem.m_drive.arcadeDrive(0, 0);
    }
}