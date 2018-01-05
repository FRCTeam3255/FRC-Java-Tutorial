package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	DoubleSolenoid pitchSolenoid = null;

	public Shooter() {
		pitchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID_DEPLOY, RobotMap.SHOOTER_PITCH_SOLENOID_RETRACT);
	}
	
	public void pitchUp() {
		pitchSolenoid.set(Value.kForward);
	}
	
	public void pitchDown() {
		pitchSolenoid.set(Value.kReverse);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

