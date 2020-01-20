
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public final class ControllerMap{
  //Driver Port
  public static XboxController driverController = new XboxController(0);
  //Operator Port
  public static XboxController operatorController = new XboxController(1);
  //Controller Potentiometer mapping
  public static final int joystick_LX = 0;
  public static final int joystick_LY = 1;
  public static final int trigger_L = 2;
  public static final int trigger_R = 3;
  public static final int joystick_RX = 4;
  public static final int joystick_RY = 5;
  //Controller Button Mapping
  public static int button_A = 1;
  public static final int button_B = 2;
  public static final int button_X = 3;
  public static final int button_Y = 4;
  public static final int bumper_L = 5;
  public static final int bumper_R = 6;
  public static final int button_LStick = 9;
  public static final int button_RStick = 10;
}
