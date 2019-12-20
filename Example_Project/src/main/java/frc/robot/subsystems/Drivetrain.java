package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.RobotPreferences;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Talon leftFrontTalon = null;
  Talon rightFrontTalon = null;
  Talon leftBackTalon = null;
  Talon rightBackTalon = null;

  SpeedControllerGroup leftMotors = null;
  SpeedControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  Encoder driveEncoder = null;

  public Drivetrain() {
    // Talons
    leftFrontTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
    rightFrontTalon = new Talon(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
    leftBackTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
    rightBackTalon = new Talon(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);

    leftMotors = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);
    rightMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

    driveEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_A, RobotMap.DRIVETRAIN_ENCODER_B);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public double getDriveEncoderCount() {
    return driveEncoder.get();
  }

  public void resetDriveEncoder() {
    driveEncoder.reset();
  }

  /**
   * @return The distance the robot has driven in inches
   */
  public double getDriveEncoderDistance() {
    return (getDriveEncoderCount() / RobotPreferences.driveEncoderCountsPerFoot()) * 12;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveArcade());
  }
}
