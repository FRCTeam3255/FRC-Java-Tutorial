# **WIP** Using Sensors and Switches

<!-- ![Image Title](imageURL)

## Overview 

In this section we will be going over

1. Creating and using a switch in the shooter subsystem
2. Creating an encoder in the drivetrain subsystem

***

## What Are Sensors

- There are different types of sensors that give feedback on different things (Ex: Encoders measure distance, switches detect touch, gyros give orientation).
- Most of these interface with the roboRIO through either the DIO, analog input, or custom electronics port.

## What Are Encoders

- Encoders are sensors that are able to measure the amount has rotated by using a laser or a shaft.
- Unlike potentiometers their shafts can continuously rotate and count infinitely* positive or negative.

## Setting Up Switches

!!! summary ""
    **1)** For this tutorial we are going to add a **switch** to the **shooter subsystem** to automatically change the pitch of the shooter
    
    - Inside the shooter subsystem we are going to create a **switch** called **shooterSwitch**
    - It will be created as a **DigitalInput**
    - The **DigitalInput** constructor only takes 1 parameter - (new DigitalInput(port)
    - The port refers to the port numbers on the RoboRIO’s DIO
    - Store the port in **RobotMap**
    
??? Example

	The code you typed should be this
	
	'''java
	DigitalInput shooterSwitch = null;
	   '''
	   
	In the constructor
	
	'''java
	shooterSwitch = new DigitalInput(RobotMap.SHOOTER_SWITCH)
	   '''
	   
	In **RobotMap.Java**
	
	'''java
	// Digital Inputs
  	public static final int SHOOTER_SWITCH = 0;
	   '''
	
## Creating isShooterSwitchClosed Method

!!! summary ''
    **1)** Create a **public boolean** method called **isShooterSwitchClosed**
    
    - This method will tell us when the shooter switch is pressed

!!! summary ''
    **2)** Inside type:
   
    '''java
    return shooterSwitch.get();
       '''

<!-- TODO: Add a tip about keeping inversions at the lowest level or in the subsystems -->
   - Switches have 2 states: open and closed.
   - Depending on how they are wired or coded only one of the 2 states will return either true or false (booleans).
   - Make sure you know which is true or false or you may have to invert the switch by rewiring or using the ! operator
   
??? Example
	
	Your **isShooterSwitchClosed()** should look like this
	
	'''java
	public boolean isShooterSwitchClosed() {
   	   return shooterSwitch.get();
  	}
	   '''
	   
## Creating ShooterUpAuto Command

- We will create a **command** that gives an example of how a Shooter switch may be used

!!! summary ""
     **1)** For this tutorial we will use the switch to create a button that automatically pitches the shooter up after the switch is pressed

!!! summary ""
    **2)** Create a new **command** called **ShooterUpAuto**
   
!!! summary "" 
    **3)** In the constructor add requires(Robot.m_Shooter)
    
!!! summary ""
    **4)** In isFinished return our **isShooterSwitchClosed** method
    
    - we will not put anything in initialize or execute because we don't want anything to happen until the switch is closed
    
!!! summary "" 
    **5)** In end add our **pitchUp** method
     
    - we will not put end in interruped either because we only want to change the pitch of the shooter if the switch is closed
    
??? Example

    Your full **ShooterUpAuto.java** should look like this
    
    '''java
    package frc.robot.commands;

    import edu.wpi.first.wpilibj.command.Command;
    import frc.robot.Robot;

    public class ShooterUpAuto extends Command {
      public ShooterUpAuto() {
      // Use requires() here to declare subsystem dependencies
      // eg. requires(chassis);
      requires(Robot.m_shooter);
      }

      // Called just before this Command runs the first time
      @Override
      protected void initialize() {
      }

      // Called repeatedly when this Command is scheduled to run
      @Override
      protected void execute() {
      }

      // Make this return true when this Command no longer needs to run execute()
      @Override
      protected boolean isFinished() {
        return Robot.m_shooter.isShooterSwitchClosed();
      }

      // Called once after isFinished returns true
      @Override
      protected void end() {
        Robot.m_shooter.pitchUp();
      }

      // Called when another command which requires one or more of the same
      // subsystems is scheduled to run
      @Override
      protected void interrupted() {
      }
    }

### Mapping ShooterAutoUpCommand
	
- To be able to test our command right now we can map it to a joystick button like we did our other Shooter commands
- It would be best to make it a whenPressed or whileHeld button
   - whileHeld will run normally while the button is being held and be interrupted when released
   
??? Example

	The code you typed should be this
	
	'''java
	D3.whenPressed(new ShooterUpAuto());
	   '''
	   
	Or this
	
	'''java
	D3.whileHeld(new ShooterUpAuto());
	   '''
	   
## Programming Encoders

!!! summary ""
    **1)** For this tutorial we are going to add a **encoder** to the **Drivetrain** subsystem to keep track of the distance the robot has driven
    
!!! summary ""
    **2)** Inside the **Drivetrain** subsystem we are going to create an **encoder** called **driveEncoder**
    
    - It will be created as an Encoder
    - The Encoder constructor takes 2 parameters - (new Encoder(port1,port2))
    - These are DIO ports on the RoboRIO
    - Store ports in RobotMap as DRIVE_ENCODER_A and B
    
??? Example 

	The code you typed outside the constructor should be this
	
	'''java
	Encoder driveEncoder = null;
	   '''
	   
	Inside the constructor
	
	'''java
	driveEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_A, RobotMap.DRIVETRAIN_ENCODER_B);
	   '''
	   
## Creating Drive Encoder Methods

!!! summary ""
    **1)** Create a public double method called **getDriveEncoderCount**
    
!!! summary ""
    **2)** Inside type: 
    
    '''java
    return driveEncoder.get();
       '''
       
    <!-- TODO: Explain why the method is a returning a double from an int -->   
    - Encoders will return counts as an int
    - Depending which direction the encoder shaft rotates the value will increase or decrease
    
!!! summary ""
    **3)** Create a public method called **resetDriveEncoderCount**
    
!!! summary ""
    **4)** Inside type:
    
    '''java
    driveEncoder.reset();
       '''
    
    - This method will reset the drive encoder to zero which is useful for autonomous or when we use the robot as a ruler
 
??? Example
	
	The code you typed should be this
	
	'''java
	public double getDriveEncoderCount() {
    	  return driveEncoder.get();
  	}

  	public void resetDriveEncoder() {
    	  driveEncoder.reset();
  	}
	   '''
	   
## Creating ResetDriveEncoder InstantCommand

- We need to create a command to use the **resetDriveEncoder** method since it’s a **void** method
- We will create a **InstantCommand** since we will only use it to reset the drive encoder

!!! summary ""
    **1)** Create a new **InstantCommand** called **DriveResetEncoder**
    
!!! summary ""
    **2)** In the constructor add requires(Robot.m_drivetrain)
    
!!! summary ""
    **3)** In initialize() add our **resetDriveEncoder** method
    
??? Example

	Your full **DriveResetEncoder** command should look like this
	
	'''java
	package frc.robot.commands;

	import edu.wpi.first.wpilibj.command.InstantCommand;
	import frc.robot.Robot;

	/**
 	* Add your docs here.
 	*/
	public class DriveResetEncoder extends InstantCommand {
  	/**
   	* Add your docs here.
   	*/
  	 public DriveResetEncoder() {
    	   super();
    	   // Use requires() here to declare subsystem dependencies
    	   // eg. requires(chassis);
    	   requires(Robot.m_drivetrain);
  	 }

  	 // Called once when the command executes
  	 @Override
  	 protected void initialize() {
    	   Robot.m_drivetrain.resetDriveEncoder();
  	 }

	}
