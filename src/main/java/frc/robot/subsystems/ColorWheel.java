/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ColorWheelConstants;

public class ColorWheel extends SubsystemBase {
  private final Spark motor = new Spark(ColorWheelConstants.motor);
  private final static ColorSensorV3 colorSensor = new ColorSensorV3(Port.kOnboard);

  private static final ColorMatch colorMatcher = new ColorMatch();
  
  private final static Color kBlue = ColorMatch.makeColor(0.143, 0.427, 0.429); // r, g, b
  private final static Color kGreen = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final static Color kRed = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final static Color kYellow = ColorMatch.makeColor(0.361, 0.524, 0.113);
  private static String color;
  private static String matchColor;
  private static String goalColor;

  /**
   * Creates a new ColorWheel.
   */
  public ColorWheel() {
    colorMatcher.setConfidenceThreshold(.08);
    colorMatcher.addColorMatch(kBlue);
    colorMatcher.addColorMatch(kGreen);
    colorMatcher.addColorMatch(kRed);
    colorMatcher.addColorMatch(kYellow);
  }

  @Override
  public void periodic() {
    SmartDashboard.putString("Target Color", getTargetColor());
    SmartDashboard.putString("Match Color", getMatchColor());
    //SmartDashboard.putString("Robot Color", getClosestColor());
    // This method will be called once per scheduler run
  }

  public void setMotor(double speed) {
    motor.set(speed);
  }

  public static String getClosestColor() {
    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
    if (match.color == kBlue) {
      color = "B";
    } if (match.color == kRed) {
      color = "R";
    } if (match.color == kGreen) {
      color = "G";
    } if (match.color == kYellow) {
      color = "Y";
    } else {
      color = "Unknown";
    }
    return color;
  }
  public static String getMatchColor() {
    matchColor = DriverStation.getInstance().getGameSpecificMessage();
    if(matchColor == null) {
      matchColor = "Unkown";
    }
    return matchColor;
  }
 public static String getTargetColor() {
   switch(getMatchColor()) {
    case "R":
      goalColor = "B";
      break;
    case "G":
      goalColor = "Y";
      break;
    case "Y":
      goalColor = "G";
      break;
    case "B":
      goalColor = "R";
      break;
   }
  //  if (getMatchColor() == "R") {
  //    goalColor = "B";
  //  }
  //  if (getMatchColor() == "G") {
  //    goalColor = "Y";
  //  }
  //  if (getMatchColor() == "Y") {
  //    goalColor = "G";
  //  }
  //  if (getMatchColor() == "B") {
  //    goalColor = "R";
  //  }
  //  else{
  //    goalColor = "Unkown";
  //  }
  //  return goalColor;
    return goalColor;
 }
}