
package frc.robot.Maps;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;;

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
  //Xbox Bumpers
  public static boolean d_Bumper_L = driverController.getBumper(GenericHID.Hand.kLeft);
  public static boolean d_Bumper_R = driverController.getBumper(GenericHID.Hand.kRight);
  public static boolean o_Bumper_L = operatorController.getBumper(GenericHID.Hand.kLeft);
  public static boolean o_Bumper_R = operatorController.getBumper(GenericHID.Hand.kRight);
  //Xbox Triggers
  public static double d_Trigger_L() {return driverController.getTriggerAxis(GenericHID.Hand.kLeft);}
  public static double d_Trigger_R() {return driverController.getTriggerAxis(GenericHID.Hand.kRight);}
  public static double o_Trigger_L() {return operatorController.getTriggerAxis(GenericHID.Hand.kLeft);}
  public static double o_Trigger_R() {return operatorController.getTriggerAxis(GenericHID.Hand.kRight);}
  //Xbox Joystick X-Axis
  public static double d_X_Axis_L() {return driverController.getX(GenericHID.Hand.kLeft);}
  public static double d_X_Axis_R() {return driverController.getX(GenericHID.Hand.kRight);}
  public static double o_X_Axis_L() {return operatorController.getX(GenericHID.Hand.kLeft);}
  public static double o_X_Axis_R() {return operatorController.getX(GenericHID.Hand.kRight);}
  //Xbox Joystick Y-Axis
    //Driver
  public static double d_Y_Axis_L() {return driverController.getY(GenericHID.Hand.kLeft);}
  public static double d_Y_Axis_R() {return driverController.getY(GenericHID.Hand.kRight);}
    //Operator
  public static double o_Y_Axis_L() {return operatorController.getY(GenericHID.Hand.kLeft);}
  public static double o_Y_Axis_R() {return operatorController.getY(GenericHID.Hand.kRight);}
  //Xbox Buttons
    //Driver
  public static boolean d_B_Button = driverController.getBButton();
  public static boolean d_A_Button = driverController.getAButton();
  public static boolean d_X_Button = driverController.getXButton();
  public static boolean d_Y_Button = driverController.getYButton();
    //Operator
  public static boolean o_B_Button = operatorController.getBButton();
  public static boolean o_A_Button = operatorController.getAButton();
  public static boolean o_X_Button = operatorController.getXButton();
  public static boolean o_Y_Button = operatorController.getYButton();

  public static boolean o_B_Button_Press = operatorController.getBButtonPressed();
  public static boolean o_A_Button_Press = operatorController.getAButtonPressed();
  public static boolean o_X_Button_Press = operatorController.getXButtonPressed();
  public static boolean o_Y_Button_Press = operatorController.getYButtonPressed();
}

