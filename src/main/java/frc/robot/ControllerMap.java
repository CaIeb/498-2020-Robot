
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public final class ControllerMap{
  //Driver Port
  public XboxController driverController = new XboxController(0);
  //Operator Port
  public XboxController operatorController = new XboxController(1);
  //Controller Potentiometer mapping
  public final int joystick_LX = 0;
  public final int joystick_LY = 1;
  public final int trigger_L = 2;
  public final int trigger_R = 3;
  public final int joystick_RX = 4;
  public final int joystick_RY = 5;
  //Controller Button Mapping
  public int button_A = 1;
  public final int button_B = 2;
  public final int button_X = 3;
  public final int button_Y = 4;
  public final int bumper_L = 5;
  public final int bumper_R = 6;
  public final int button_LStick = 9;
  public final int button_RStick = 10;
  //Xbox Bumpers
  public boolean d_Bumper_L = driverController.getBumper(Hand.kLeft);
  public boolean d_Bumper_R = driverController.getBumper(Hand.kRight);
  public boolean o_Bumper_L = operatorController.getBumper(Hand.kLeft);
  public boolean o_Bumper_R = operatorController.getBumper(Hand.kRight);
  //Xbox Triggers
  public double d_Trigger_L = driverController.getTriggerAxis(Hand.kLeft);
  public double d_Trigger_R = driverController.getTriggerAxis(Hand.kRight);
  public double o_Trigger_L = operatorController.getTriggerAxis(Hand.kLeft);
  public double o_Trigger_R = operatorController.getTriggerAxis(Hand.kRight);
  //Xbox Joystick X-Axis
  public double d_X_Axis_L = driverController.getX(Hand.kLeft);
  public double d_X_Axis_R = driverController.getX(Hand.kRight);
  public double o_X_Axis_L = operatorController.getX(Hand.kLeft);
  public double o_X_Axis_R = operatorController.getX(Hand.kRight);
  //Xbox Joystick Y-Axis
    //Driver
  public double d_Y_Axis_L = driverController.getY(Hand.kLeft);
  public double d_Y_Axis_R = driverController.getY(Hand.kRight);
    //Operator
  public double o_Y_Axis_L = operatorController.getY(Hand.kLeft);
  public double o_Y_Axis_R = operatorController.getY(Hand.kRight);
  //Xbox Buttons
    //Driver
  public boolean d_B_Button = driverController.getBButton();
  public boolean d_A_Button = driverController.getAButton();
  public boolean d_X_Button = driverController.getXButton();
  public boolean d_Y_Button = driverController.getYButton();
    //Operator
  public boolean o_B_Button = operatorController.getBButton();
  public boolean o_A_Button = operatorController.getAButton();
  public boolean o_X_Button = operatorController.getXButton();
  public boolean o_Y_Button = operatorController.getYButton();
}
