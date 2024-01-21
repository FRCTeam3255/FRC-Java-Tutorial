# [WIP] Creating an Autonomous Command

<!-- ![Image Title](imageURL)  -->

## Overview

In this section we will be going over

1. Creating an autonomous command group
2. Using RobotPreferences to quickly change our autonomous values
3. Using an encoder to autonomously drive
4. Creating a delay timer to pace our commands in autonomous

<!-- TODO: Implement and revamp autonomous status code from robot2018/2019? -->
<!-- 5. Creating an autonomous status readout in shuffleboard to aid in debugging autonomous -->

***

## What Is an Autonomous Command

- An autonomous command is a command that is ran during "autonomous mode" under the **autonomousInit** method in **Robot.java** 
- It could be a single **command** or a **command group**
- It's especially helpful to have if you don't have any cameras to drive the robot during a 
"sandstorm" period (2019 game mechanic where the drivers couldn't see during the pre tele-op phase)
- For this tutorial we will create an autonomous **command group** that makes the robot drive forward 5 feet, wait 5 seconds, and then pitch the shooter up during autonomous 
	
## Creating Commands For Autonomous

- Since we can't control our robot during an autonomous command we will want to create commands that allow the robot to move independently of a driver

## Creating the DriveDistance Command 

!!! summary ""
    **1)** Create a new command called **DriveDistance**
    
!!! summary ""
    **2)** Before the constructor create a **double** called **distance**
    
    - We will use this to tell the command to finish when the robot drives the inputted distance
    
!!! summary ""
    **3)** In the **DriveDistance** constructor add a **double** parameter called **inches**
    
!!! summary ""
    **4)** Inside type:
    
	```java
	distance = inches;
	```
        
!!! summary ""
    **5)** In **initialize** add our **resetDriveEncoder** method
    
    - We want to reset the encoder before we drive so that it counts the distance from zero
    
!!! summary ""
    **6)** In **execute** add our **arcadeDrive** method and change the **moveSpeed** parameter to a **RobotPreference** named **driveDistanceSpeed** and **rotateSpeed** to 0.0
    
    - We only want to drive the robot forward; a **RobotPreference** will help us tune the drive speed
    
!!! summary ""
    **7)** In **isFinished** type:
    
	```java
	return Robot.m_drivetrain.getDriveEncoderDistance() == distance;
	```
!!! summary ""
    **8)** In **end** stop the **Drivetrain** and call **end** in **interrupted**
    
??? Example
    
	Your full **DriveDistance.java** should look like this
	
	```java
	package frc.robot.commands;

	import edu.wpi.first.wpilibj.command.Command;
	import frc.robot.Robot;
	import frc.robot.RobotPreferences;

	public class DriveDistance extends Command {

		private double distance;

		public DriveDistance(double inches) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.m_drivetrain);
		distance = inches;
		}

		// Called just before this Command runs the first time
		@Override
		protected void initialize() {
		Robot.m_drivetrain.resetDriveEncoder();
		}

		// Called repeatedly when this Command is scheduled to run
		@Override
		protected void execute() {
		Robot.m_drivetrain.arcadeDrive(RobotPreferences.driveDistanceSpeed(), 0.0);
		}

		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
		return Robot.m_drivetrain.getDriveEncoderDistance() == distance;
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {
		Robot.m_drivetrain.arcadeDrive(0.0, 0.0);
		}

		// Called when another command which requires one or more of the same
		// subsystems is scheduled to run
		@Override
		protected void interrupted() {
		end();
		}
	}
	```
		   
	The code you typed in **RobotPreferences.java** should be this
	
	```java
	public static final double driveDistanceSpeed() {
		return Preferences.getInstance().getDouble("driveDistanceSpeed", 0.5);
	}
	```

## Creating The Autonomous Command

- We will create an **Autonomous command group** with the **DriveDistance** command and the **ShooterPitchUp** command

!!! summary ""
    **1)** Create a new **Command Group** named **Autonomous**
	
!!! summary ""
 	**2)** In the constructor type
	
	```java
	addSequential(new DriveDistance(RobotPreferences.autoDriveDistance()));
	addSequential(new ShooterUp());
	```
		   
	- To add a **command** to run in a **command group** use **addSequential** to execute commands in order
	
## Creating the DoDelay Command

- In order to add timing in between our **commands** in our **command groups** we will need to create a **DoDelay** command
- Unlike regular **delays** the **DoDelay** command will not stall our robot, but wait a certain amount of time before running a command

!!! summary ""
	**1)** Create a new command called **DoDelay**
	
!!! summary ""
	**2)** Before the constructor add two private **doubles** called **expireTime** and **timeout**
		   
!!! summary ""
	**3)** In the constructor add a **double** called **seconds** in the parameter
	
!!! summary ""
	**4)** Inside the constructor set **timeout** equal to **seconds**

!!! summary ""
	**5)** Create a protected **void** method called **startTimer**

!!! summary ""
	**6)** Inside set **expireTime** equal to **timeSinceInitialized** + **timeout**
	
	- This will let the robot know how much time will have passed since the command was initialized when it finishes
	
!!! summary ""
	**7)** In **initialized** add our **startTimer** method
	
!!! summary ""
	**8)** In **isFinished** return **timeSinceInitialized** is greater or equal to **expireTime**
	
??? Example

	Your full **DoDelay.java** should look like this
	
	```java
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
	```
    
## Adding the DoDelay Command to Autonomous.java

!!! summary ""
	- Add our **DoDelay** command in between **DriveDistance** and **ShooterPitchUp** with a **RobotPreference** called **autoDelay**
	
??? Example 

	Your full **Autonomous.java** should look like this
	
	```java
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
	```
		
	The code you typed in **RobotPreferences.java** should look like this
	
	```java
	public static double autoDelay() {
		return Preferences.getInstance().getDouble("autoDelay", 5.0);
	}

	public static double autoDriveDistance() {
		return Preferences.getInstance().getDouble("autoDriveDistance", 12.0);
	}
	```

## Adding Our Autonomous Command to Robot.java

- In order to run our **Autonomous** command in autonomous we will have to put it in **Robot.java** so that it will run as soon as the robot enters the autonomous mode

- In **Robot.java** under **autonomousInit** find **m_autonomousCommand = m_chooser.getSelected();** and change it to
		
	<!-- TODO: Explain why we don't use chooser? -->
	
	```java
	public void autonomousInit() {
	m_autonomousCommand = new Autonomous();
	...
	```
		   
## Testing Our Autonomous Command

- Now that we have finished coding our **Autonomous** command deploy code and add our new **RobotPreferences** to the widget on the **ShuffleBoard**
- We have three preferences that change our autonomous behavior **driveDistanceSpeed**, **autoDriveDistance** and **autoDelay**
- **driveDistanceSpeed** will determine the **direction** and how **fast** the robot drives 
- **autoDriveDistance** will determine how many **inches** the robot drives **forward** or **backward**  
- **autoDelay** will determine how long the robot **waits** before executing **ShooterPitchUp**
- Change these values before enabling your robot in autonomous to make you get the desired results

## Tips For Debugging Our Autonomous Command

- If the robot doesn't seem to stop moving or drive in the right direction check for inversions in your **Drive** commands or in the **Drivetrain** subsystem
  - You may also need to check if your **encoder** is working, if there are inversions, or if you are using the **getEncoderCount** method instead of the **getEncoderDistanceMethod**
- If your robot doesn't move make sure you typed in the **RobotPreference** names exactly or check your talon IDs/Connection
- If nothing happens after your robot is finished driving check your **autoDelay** preference and whether your **Shooter piston** is already actuated or if your solenoids are working
