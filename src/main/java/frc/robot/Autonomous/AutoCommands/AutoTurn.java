package frc.robot.Autonomous.AutoCommands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Sensors.Gyro;

public class AutoTurn extends Command {
    
    public double turnAngle;
    public double speed;
    /** 
     * @param turnAngle Angle to turn
     * @param speed Speed to turn (Negative Value is Backwards)
    */
    public AutoTurn(double turnAngle, double speed){
        this.turnAngle = turnAngle;
        this.speed = speed;
        /*
        double kp = turnAngle - Gyro.gyroZangle();
        turnAngle = turnAngle + kp;
        */
    }
    protected boolean isFinished() {
        return Math.abs(Gyro.gyroZangle()) >= turnAngle;
    }
    protected void initialize() {
        Gyro.gyro.reset();
    }
    protected void execute() {
        DriveSubsystem.m_drive.arcadeDrive(0, speed);
    }
    protected void end(){
        DriveSubsystem.m_drive.arcadeDrive(0, 0);
    }
}