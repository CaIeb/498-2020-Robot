// package frc.robot.Sensors;

// import edu.wpi.first.wpilibj.I2C.Port;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.util.Color;

// import com.revrobotics.ColorSensorV3;
// import com.revrobotics.ColorMatch;
// import com.revrobotics.ColorMatchResult;

// public class ColorSensor {
//    public static Port colorPort = Port.kOnboard;
//    public static ColorSensorV3 colorSensor = new ColorSensorV3(colorPort);

//    public static ColorMatch colorMatcher = new ColorMatch();

//    private static Color kBlue = ColorMatch.makeColor(0.143, 0.427, 0.429); //r, g, b
//    private static Color kGreen = ColorMatch.makeColor(0.197, 0.561, 0.240);
//    private static Color kRed = ColorMatch.makeColor(0.561, 0.232, 0.114);
//    private static Color kYellow = ColorMatch.makeColor(0.361, 0.524, 0.113);

//     public static void ColorSensorInit() {
//      colorMatcher.setConfidenceThreshold(.08);
//      colorMatcher.addColorMatch(kBlue);
//      colorMatcher.addColorMatch(kGreen);
//      colorMatcher.addColorMatch(kRed);
//      colorMatcher.addColorMatch(kYellow);
//     }

//     public static String ColorSensorUpdate() {
//      Color detectedColor = colorSensor.getColor();
//      String color;
//      ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
//       if (match.color == kBlue) {
//        color = "Blue";
//       } 
//       else if (match.color == kRed) {
//        color = "Red";
//       }
//       else if (match.color == kGreen) {
//        color = "Green";
//       } 
//       else if (match.color == kYellow) {
//        color = "Yellow";
//       }
//       else {
//        color = "Unknown";
//       }
//       SmartDashboard.putString("Color", color);
//       //SmartDashboard.putNumber("Confidence", match.confidence);
//       return color;
//     }
//   }



