package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
public final class Smart_Dashboard {
    public static int pdpID = 0;
    public static PowerDistributionPanel pdp = new PowerDistributionPanel(pdpID);
    public static double pdpVoltage = pdp.getVoltage();
    //Auto Selector Definitions
    public static String m_autoSelected;
    public static final SendableChooser<String> m_chooser = new SendableChooser<>();
    public static final String auto1 = "Auto 1";
    public static final String auto2 = "Auto 2";
    public static void Smart_Dashboard_Periodic() {
        SmartDashboard.putNumber("PDP Voltage", pdpVoltage);
        SmartDashboard.putNumber("Left Encoder Value", DriveSubsystem.m_LEncoder.get());
        SmartDashboard.putNumber("Right Encoder Value", DriveSubsystem.m_REncoder.get());
    }
    public static void Smart_Dashboard_RobotInit() {
        m_chooser.setDefaultOption("Auto 1", auto1);
        m_chooser.addOption("Auto 2", auto2);
        SmartDashboard.putData("Auto choices", m_chooser);
    }
    public static void Smart_Dashboard_AutoInit() {
        m_autoSelected = m_chooser.getSelected();
        // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
        System.out.println("Auto selected: " + m_autoSelected);
    
    }

    public static void Smart_Dashboard_TeleOp() {


    }

}