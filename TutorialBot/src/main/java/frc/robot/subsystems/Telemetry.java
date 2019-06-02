/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.DrivetrainResetEncoder;
import frc.robot.commands.ShooterDown;
import frc.robot.commands.ShooterUp;

/**
 * Add your docs here.
 */
public class Telemetry extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Telemetry() {
    // Drivetrain
    SmartDashboard.putData("Reset Drive Encoder", new DrivetrainResetEncoder());

    // Shooter
    SmartDashboard.putData("Shooter Down", new ShooterDown());
    SmartDashboard.putData("Shooter Up", new ShooterUp());
  }

  public void update() {
    // Drivetrain
    SmartDashboard.putNumber("Drivetrain Encoder Count", Robot.m_drivetrain.getDriveEncoderCount());
    SmartDashboard.putNumber("Drivetrain Encoder Distance", Robot.m_drivetrain.getDriveEncoderDistance());

    // Shooter
    SmartDashboard.putBoolean("Shooter Switch", Robot.m_shooter.isShooterSwitchClosed());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
