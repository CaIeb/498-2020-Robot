/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class ClimberConstants {
        public static final int motor1 = 8;
        public static final int motor2 = 9;
        public static final int upEncoderValue = 30000;
        public static final int downEncoderValue = 78000;
        public static final int startEncoderValue = 0;
    }

    public final class DrivetrainConstants {
        public static final int motorRight1 = 1;
        public static final int motorRight2 = 2;
        public static final int motorRight3 = 3;
        public static final int motorLeft1 = 4;
        public static final int motorLeft2 = 5;
        public static final int motorLeft3 = 6;

        public static final int encoderRightA = 0;
        public static final int encoderRightB = 1;
        public static final int encoderLeftA = 2;
        public static final int encoderLeftB = 3;
        public static final double rampTolerance = .15;
    }

    public final class IntakeConstants {
        public static final int frontMotor = 1;
        public static final int backMotor = 0;
    }

    public final class WristConstants {
        public static final int motor = 7;
        public static final int potentiometer = 0;
        public static final int wristDownSensor = 4;
        public static final int wristUpSensor = 5;
    }
    public final class ControlPanelConstants {
        public static final int linearMotor = 2;
        public static final int upSensor = 6;
        public static final int downSensor = 7;
    }
    public final class ColorWheelConstants {
        public static final int motor = 3;
    }
}
