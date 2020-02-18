package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Maps.ControllerMap;
import frc.robot.Sensors.Encoders.ClimberEncoders;

public final class ClimberSubsystem {
    private static int climberID = 8;
    private static int climberFollowID = 9;

    public static WPI_TalonSRX climber = new WPI_TalonSRX(climberID);
    public static WPI_TalonSRX climberFollow = new WPI_TalonSRX(climberFollowID);

    public static int maxClimbExtension = 69;

    public static void ClimberInit() {
        climberFollow.follow(climber);
    }
    public static void ClimberTeleop() {
        boolean xButtonHold = ControllerMap.operatorController.getXButton();
        boolean aButtonHold = ControllerMap.operatorController.getBButton();

        if (xButtonHold) {
            //ClimberEncoders.RaiseClimber();
            climber.set(.5);
        }
        else if (aButtonHold) {
            //ClimberEncoders.LowerClimber();
            climber.set(-.5);
        }
        else { 
            climber.set(0);
        }
    }
}