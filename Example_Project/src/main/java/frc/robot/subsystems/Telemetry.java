package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class Telemetry extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Telemetry() {
    // Drivetrain
    SmartDashboard.putData("Reset Drive Encoder", new DriveResetEncoder());

    // Shooter
    SmartDashboard.putData("Shooter Up", new ShooterUp());
    SmartDashboard.putData("Shooter Down", new ShooterDown());
    SmartDashboard.putData("Shooter Up Auto", new ShooterUpAuto());
  }

  public void update() {
    // Drivetrain
    SmartDashboard.putNumber("Drive Encoder Count", Robot.m_drivetrain.getDriveEncoderCount());

    // Shooter
    SmartDashboard.putBoolean("Shooter Switch", Robot.m_shooter.isShooterSwitchClosed());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
