/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;

import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Climber.ClimbPosition;
import frc.robot.subsystems.Wrist.WristPosition;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.ControlPanel;

import frc.robot.commands.AutoGroups.*;
import frc.robot.commands.*;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Climber climber = new Climber();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Wrist wrist = new Wrist();
  private final ControlPanel controlPanel = new ControlPanel();
  private final ColorWheel colorWheel = new ColorWheel();
  private final SendableChooser<Command> m_autochooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link driverController}), and
   * then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    XboxController driver = new XboxController(0);
    XboxController operator = new XboxController(1);

    //Intake
    intake.setDefaultCommand(
      new TeleopIntake(intake, () -> driver.getTriggerAxis(Hand.kLeft), () -> driver.getTriggerAxis(Hand.kRight),
        () -> driver.getTriggerAxis(Hand.kLeft), ()-> driver.getTriggerAxis(Hand.kRight)));
    new Button(()-> driver.getBumper(Hand.kLeft)).toggleWhenPressed(new FrontRoller(intake, () -> driver.getTriggerAxis(Hand.kLeft), ()-> driver.getTriggerAxis(Hand.kRight), true));
    new Button(()-> driver.getBumper(Hand.kRight)).toggleWhenPressed(new FrontRoller(intake, () -> driver.getTriggerAxis(Hand.kLeft), ()-> driver.getTriggerAxis(Hand.kRight), false));

    //new Button(driver::getBumper(Hand.kRight))
    //Wrist Position
    new Button(operator::getAButton).whenPressed(new MoveWrist(wrist, WristPosition.Score));
    new Button(operator::getYButton).whenPressed(new MoveWrist(wrist, WristPosition.Load));
    new Button(()-> operator.getBumper(Hand.kRight)).whenPressed(new MoveWrist(wrist, WristPosition.Home));
    new Button(()-> operator.getBumper(Hand.kLeft)).whenPressed(new MoveWrist(wrist, WristPosition.Collect));

    //Climber
    new Button(operator::getXButton)
        .whenPressed(new MoveClimber(climber, ClimbPosition.Up));

    new Button(operator::getBButton)
        .whenHeld(new ClimberDown(climber)); 

    // new Button(operator::getBackButton)
    //     .whenPressed(new ClimberStart(climber));
    // Control Panel
    new Button(operator::getBackButton).whenPressed(new MoveControlPanelUp(controlPanel));
    new Button(operator::getStartButton).whenPressed(new MoveControlPanelDown(controlPanel));

    // Color Wheel
    //new Button(operator::getXButton).whenPressed(new InstantCommand(()-> colorWheel.setMotor(1), colorWheel));
    new Button(driver::getYButton).whenPressed(new PositionControl(colorWheel));
    new Button(driver::getAButton).whenPressed(new RotationControl(colorWheel));
    new Button(driver::getXButton).whenPressed(new Auto3(drivetrain));
    //new Button(driver::getBButton).whenPressed(new AutoDrive(drivetrain, 200, -.75));
    drivetrain.setDefaultCommand(
       new TeleopDrive(drivetrain, () -> -driver.getY(Hand.kLeft), () -> driver.getX(Hand.kRight)));
      //new Button(()-> driver.getStickButton(Hand.kLeft)).toggleWhenPressed(new TeleopDrive(drivetrain, () -> -driver.getY(Hand.kLeft) * .75, () -> driver.getX(Hand.kRight) * .85));
  }

  public void setupDashboard() {
    SmartDashboard.putNumber("Auto Dump Time", 1);
    m_autochooser.setDefaultOption("Auto 1", new Auto1(drivetrain, wrist, intake));
    m_autochooser.addOption("Auto 2", new Auto2(drivetrain, wrist, intake));
    m_autochooser.addOption("Auto 3", new Auto3(drivetrain));//new Auto3(wrist, intake, ()-> SmartDashboard.getNumber("Auto Dump Time", 1)));
    m_autochooser.addOption("Auto 4", new Auto4(drivetrain, wrist, intake, ()-> SmartDashboard.getNumber("Auto Dump Time", 1)));
    m_autochooser.addOption("Auto 5", new Auto5(drivetrain, wrist, intake));
    SmartDashboard.putData("Auto choices", m_autochooser);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autochooser.getSelected();
  }
}
