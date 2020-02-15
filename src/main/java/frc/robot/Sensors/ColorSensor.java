/*package frc.robot.Sensors;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.*;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class ColorSensor {
 public static Port colorPort = Port.kOnboard;
 public static ColorSensorV3 colorSensor = new ColorSensorV3(colorPort);
 private static Color color = colorSensor.getColor();
 private static Color blue = ColorMatch.makeColor(r, g, b)
 public static void colorBlue() {
     if (color =  ){
     }
 }
 public static void getPositionColor() {

    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B':
          //Blue case code
          break;
        case 'G' :
          //Green case code
          break;
        case 'R' :
          //Red case code
          break;
        case 'Y' :
          //Yellow case code
          break;
        default :
          //This is corrupt data
          break;
      }
    } else {
      //Code for no data received yet
    }
 }
 public static double ColorRed() {
     return colorSensor.getRed();
 }
 public static double ColorGreen() {
    return colorSensor.getGreen();
}
public static double ColorBlue() {
    return colorSensor.getBlue();
}
}
*/