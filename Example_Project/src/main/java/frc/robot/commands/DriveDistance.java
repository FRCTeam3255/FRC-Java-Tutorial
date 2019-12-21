package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotPreferences;

public class DriveDistance extends Command {

  private double distance;

  public DriveDistance(double inches) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drivetrain);
    distance = inches;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_drivetrain.resetDriveEncoder();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_drivetrain.arcadeDrive(RobotPreferences.driveDistanceSpeed(), 0.0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_drivetrain.getDriveEncoderDistance() == distance;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drivetrain.arcadeDrive(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
