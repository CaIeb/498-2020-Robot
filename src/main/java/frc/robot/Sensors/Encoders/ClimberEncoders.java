package frc.robot.Sensors.Encoders;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.Subsystems.*;

public class ClimberEncoders {
    
    private static double cpr = 1024;
    private static double reelRadius = ((getRawClimbDistance() / cpr) * (0.0625)) + (5/8);
    private static double reelCircumference = 2 * Math.PI * reelRadius;
    private static double reelToDistanceCoversionFactor = (5/16);
    private static double trueDistanceConversion = (reelCircumference * reelToDistanceCoversionFactor);
    public static double maxClimbInches = 69;
    public static int maxClimberExtension = (int) Math.round(26214.4 * (maxClimbInches) - 5120);
    public static int minClimberExtension = 0;    

    public static double getRawClimbDistance() {
        return ClimberSubsystem.climber.getSelectedSensorPosition();
    }

    public static void configureEncoders() { //for MagEncoders
        ClimberSubsystem.climber.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        
    }

    public static double getClimberExtension() {
     return (getRawClimbDistance() * trueDistanceConversion);
    }
    public static void RaiseClimber() {
        ClimberSubsystem.climber.setSelectedSensorPosition(maxClimberExtension);
    }
    public static void LowerClimber() {
        ClimberSubsystem.climber.setSelectedSensorPosition(minClimberExtension);
    }
    
}