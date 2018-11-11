/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ShooterDown;
import frc.robot.commands.ShooterUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick driverController = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);

	Button D1 = new JoystickButton(driverController, 1);
	Button D2 = new JoystickButton(driverController, 2);
	Button D3 = new JoystickButton(driverController, 3);
	Button D4 = new JoystickButton(driverController, 4);
	Button D5 = new JoystickButton(driverController, 5);
	Button D6 = new JoystickButton(driverController, 6);
	Button D7 = new JoystickButton(driverController, 7);
	Button D8 = new JoystickButton(driverController, 8);
	Button D9 = new JoystickButton(driverController, 9);
	Button D10 = new JoystickButton(driverController, 10);

	public OI() {
		D1.whenPressed(new ShooterUp());
		D2.whenPressed(new ShooterDown());
	}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
