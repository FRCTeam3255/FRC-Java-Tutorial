/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// Solenoids
	DoubleSolenoid pitchSolenoid = null;

	// Switches
	DigitalInput shooterSwitch = null;

	public Shooter() {
		// Solenoids
		pitchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID_DEPLOY,
				RobotMap.SHOOTER_PITCH_SOLENOID_RETRACT);

		// Switches
		shooterSwitch = new DigitalInput(RobotMap.SHOOTER_SWITCH);
	}

	public void pitchUp() {
		pitchSolenoid.set(Value.kForward);
	}

	public void pitchDown() {
		pitchSolenoid.set(Value.kForward);
	}

	public boolean isShooterSwitchClosed() {
		return shooterSwitch.get();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
