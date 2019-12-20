package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class DoDelay extends Command {

  private double expireTime;
  private double timeout;

  public DoDelay(double seconds) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    timeout = seconds;
  }

  protected void startTimer() {
    expireTime = timeSinceInitialized() + timeout;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTimer();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (timeSinceInitialized() >= expireTime);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
