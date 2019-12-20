package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotPreferences;

public class Autonomous extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Autonomous() {
    addSequential(new DriveDistance(RobotPreferences.autoDriveDistance()));
    addSequential(new DoDelay(RobotPreferences.autoDelay()));
    addSequential(new ShooterUp());
  }
}
