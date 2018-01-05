package org.usfirst.frc.team3255.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	// Talons
	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 0;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 1;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 3;
	
	// Joysticks
	public static final int OI_DRIVER_CONTROLLER = 0;
	public static final int JOYSTICK_MOVE_AXIS = 1;
	public static final int JOYSTICK_ROTATE_AXIS = 2;
	
	// Solenoids
	public static final int SHOOTER_PITCH_SOLENOID_DEPLOY = 0;
	public static final int SHOOTER_PITCH_SOLENOID_RETRACT = 1;
}
