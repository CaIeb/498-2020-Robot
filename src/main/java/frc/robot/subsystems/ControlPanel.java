package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ControlPanelConstants;;

public class ControlPanel extends SubsystemBase {
    private final Spark linearMotor = new Spark(ControlPanelConstants.linearMotor);
    private final DigitalInput upSensor = new DigitalInput(ControlPanelConstants.upSensor);
    private final DigitalInput downSensor = new DigitalInput(ControlPanelConstants.downSensor);

    public void setLinear(double speed) {
        linearMotor.set(speed);
    }

    public boolean getUpSensor() {
        return !upSensor.get();
    }
    
    public boolean getDownSensor() {
        return !downSensor.get();
    }
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      SmartDashboard.putBoolean("Down Limit", getDownSensor());
      SmartDashboard.putBoolean("Up Limit", getUpSensor());
    }
}