package frc.robot;

import edu.wpi.first.wpilibj.DigitalSource;

public class RobotMap {
  // Talons
  public static final int DRIVETRAIN_LEFT_FRONT_TALON = 0;
  public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 1;
  public static final int DRIVETRAIN_LEFT_BACK_TALON = 2;
  public static final int DRIVETRAIN_RIGHT_BACK_TALON = 3;

  // Solenoids
  public static final int SHOOTER_PITCH_SOLENOID_DEPLOY = 0;
  public static final int SHOOTER_PITCH_SOLENOID_RETRACT = 1;

  // Digital Inputs
  public static final int SHOOTER_SWITCH = 0;

  // Encoders
  public static final int DRIVETRAIN_ENCODER_A = 1;
  public static final int DRIVETRAIN_ENCODER_B = 2;

  // Joysticks
  public static final int OI_DRIVER_CONTROLLER = 0;
  public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1; // Change for your controller
  public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 2; // Change for your controller
}
