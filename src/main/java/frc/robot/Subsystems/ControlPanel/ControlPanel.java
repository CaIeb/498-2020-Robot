package frc.robot.Subsystems.ControlPanel;

import frc.robot.Maps.ControllerMap;

public class ControlPanel {
    double encodercpr = 28;
    double gearReduction = 5.2;
    double outputcpr = encodercpr * gearReduction;
    double motorToLeadScrewReduction = 1;
    double leadscrewCPR = outputcpr * motorToLeadScrewReduction;
    double linearExtensionPerRev_mm = 8;
    double linearExtensionPerRev_in = 8/25.4;

    public static void controlPanelUp() {
        if (ControlPanelSensors.getControlPanelUp() == false && ControllerMap.d_Y_Button) {
            ControlPanelSensors.controlPanelMotor.set(.8);
        }
        else {
            ControlPanelSensors.controlPanelMotor.set(0);
        }
    }
    public static void controlPanelDown() {
        if (ControlPanelSensors.getControlPanelDown() == false && ControllerMap.d_A_Button) {
         ControlPanelSensors.controlPanelMotor.set(-.8);
        }
        else {
         ControlPanelSensors.controlPanelMotor.set(0);
        }   
    }   
    public static void ControlPanelTeleOp() {
     controlPanelDown();
     controlPanelUp();
    }

}