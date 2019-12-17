<!-- This page was contributed by: Isaac Sayasane -->
# Using Pneumatics

Check the air pressure
<!-- Add a page image to make it pretty! -->
![Image Title](imageURL)

## Overview

In this section we will be going over:

1. Creating a shooter subsystem that uses one pneumatic pistion
2. Creating a double solenoid and changing its state to control the piston
3. Mapping commands to joystick buttons

***

### What Are Pneumatics

- You have probably heard of hydraulics before (which is based onwater pressure). Pneumatics are essentially the same but with air pressure.
- Unlike motors and gears which are commonly infinitely positional, pneumatic cylinders are normally dual-positional or sometimes tripositional.
- Pneumatic cylinders are actuated through devices called solenoids.
- Solenoids are used to control pneumatic pistons (air cylinders) similar to how Talons control motors.

### What Are Solenoids

- Cylinders are actuated with either **single solenoids** or **double solenoids**.
- A **single solenoid** actuates with one air line, using air to switch to and hold the extended state and releasing air (sometimes paired with a spring) to allow the cylinder to return to the retracted state.
	- A single solenoid valve has one solenoid, and shifts when voltage is **CONSTANTLY** supplied to that solenoid. When voltage is removed, it shifts back to a "home" position.
- A **double solenoid** actuates with two air lines, using air to switch and hold states between retracted and extended.
	- A double solenoid has two solenoids, and when voltage is supplied to one (and not the other) the valve shifts.
- Solenoids are connected to the Pneumatics Control Module (PCM)
	- The PCM is connected to the roboRIO via the CAN bus.
	
### Programming Solenoids

!!! summary ""
**1)** For this tutorial we are going to create a new subsystem called shooter and add one pneumatic piston (cylinder) which will be used for changing the pitch of the shooter.

- Create your new Shooter subsystem on your own now
	- DON’T FORGET TO ADD IT TO ROBOT.JAVA
- It will be controlled through a double solenoid.
- We are going to create a DoubleSolenoid named pitchSolenoid.
	- DoubleSolenoids have 2 controllable positions (deployed(forward) and retracted(reverse)).
	- The DoubleSolenoid constructor takes 2 parameters - (new DoubleSolenoid(port1, port2) )
		- Port 1 and Port 2 refer to Forward control and Reverse control ports on the PCM.
		- Like all ports we use, we will store this in the RobotMap.

!!! summary ""
**2)** Create your DoubleSolenoid named pitchSolenoid now using the same technique used to create a talon but replacing Talon with DoubleSolenoid. (For single solenoids just use Solenoid).

??? Example

	Your full **Shooter.java** should look like this
	
     '''java
     package frc.robot.subsystems;

     import edu.wpi.first.wpilibj.DoubleSolenoid;
     import edu.wpi.first.wpilibj.command.Subsystem;
     import frc.robot.RobotMap;

     /**
     * Add your docs here.
     */
     public class Shooter extends Subsystem {
  	// Put methods for controlling this subsystem
  	// here. Call these from Commands.
  	DoubleSolenoid pitchSolenoid = null;

   	public Shooter() {
    	   pitchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID_DEPLOY, RobotMap.SHOOTER_PITCH_SOLENOID_RETRACT);
  	}

  	@Override
  	public void initDefaultCommand() {
   	// Set the default command for a subsystem here.
    	// setDefaultCommand(new MySpecialCommand());
  	}
      }
      	'''
	
	The code you typed in **Robot.java** should be this
	
	Oustide robotInit
	'''java
	public static Shooter m_shooter = null;
	   '''
	Inside robotInit
	'''java
	m_shooter = new Shooter();
	   '''
	  
	The code you typed in **RobotMap.java** should be this
	
	'''java
	// Solenoids
  	public static final int SHOOTER_PITCH_SOLENOID_DEPLOY = 0;
  	public static final int SHOOTER_PITCH_SOLENOID_RETRACT = 1;
	   '''
	
   
