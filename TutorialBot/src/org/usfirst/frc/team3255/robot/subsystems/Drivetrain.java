package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	// Motor Controllers
	Talon leftFrontTalon = null;
	Talon leftBackTalon = null;
	Talon rightFrontTalon = null;
	Talon rightBackTalon = null;
	
	// Robot Drive
	RobotDrive robotDrive = null;
	
	public Drivetrain() {
		// Talons
		leftFrontTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new Talon(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		leftBackTalon = new Talon(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		// Robot Drive
		robotDrive = new RobotDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		robotDrive.arcadeDrive(moveSpeed, moveSpeed);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveArcade());
    }
}