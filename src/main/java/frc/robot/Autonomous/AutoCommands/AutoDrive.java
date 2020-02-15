package frc.robot.Autonomous.AutoCommands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Sensors.Encoders.DriveEncoders;

public class AutoDrive extends Command {
    
    public double distance;
    public double speed;
    private double stopTolerance = 1;
    private double startTolerance =  10 + stopTolerance;
    private double endTolerance = 10 - stopTolerance;
    private double kP = distance - DriveEncoders.getTrueLeftDistance();
    private double kI = .01;
    private double toleranceSpeedFactor() {
        return kP * kI;
    }
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
         return (Math.abs(DriveEncoders.getTrueLeftDistance()) < distance +  stopTolerance && Math.abs(DriveEncoders.getTrueLeftDistance()) > distance - stopTolerance);
    }
    protected void initialize() {
        DriveEncoders.resetEncoders();
    }
    protected void execute() {
        if (DriveEncoders.getTrueLeftDistance() > (distance + startTolerance) || DriveEncoders.getTrueLeftDistance() < (distance - endTolerance) ){
            DriveSubsystem.m_drive.arcadeDrive(speed, 0);
        }
        else if (DriveEncoders.getTrueLeftDistance() < (distance + startTolerance) && DriveEncoders.getTrueLeftDistance() > (distance - endTolerance)) {
            DriveSubsystem.m_drive.arcadeDrive(speed * toleranceSpeedFactor(), 0);
        }
        else {
            end();
        }
    }
    protected void end(){
        DriveSubsystem.m_drive.arcadeDrive(0, 0);
    }
}