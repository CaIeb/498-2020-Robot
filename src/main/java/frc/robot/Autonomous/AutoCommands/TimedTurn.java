package frc.robot.Autonomous.AutoCommands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.Subsystems.DriveSubsystem;
public class TimedTurn extends Command {
    public double turnSpeed;
    public double time;
    private Timer autoTimer = new Timer();
    public TimedTurn(double time, double turnSpeed) {
        this.time = time;
        this.turnSpeed = turnSpeed;

    }
    protected boolean isFinished() {
        return autoTimer.get() >= time;
    }
    protected void initialize() {
        autoTimer.start();
    }
    protected void execute() {
        //DriveSubsystem.m_drive.arcadeDrive(0, turnSpeed);
    }
    protected void end() {
        //DriveSubsystem.m_drive.arcadeDrive(0, 0);
    }
}