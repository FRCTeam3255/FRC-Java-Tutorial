package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ShooterDown extends InstantCommand {
  /**
   * Add your docs here.
   */
  public ShooterDown() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_shooter);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.m_shooter.pitchDown();
  }

}
