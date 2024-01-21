# [WIP] Using Shuffleboard

<!-- ![Image Title](imageURL)  -->

## Overview

In this section we will be going over

1. Using and organizing the Shuffleboard
2. Creating the Telemetry subsystem and adding buttons and data to be viewed in Shuffleboard

***

## What is Shuffleboard

- **Shuffleboard** is one of the boards the driverstation displays robot data with
- It can have widgets like graphs, camera streams, and meters
- Unique to **shuffleboard** is the ability to have tabs for different boards

## What is Telemetry

- **Telemetry** is where we add data to be viewed or command buttons on **shuffleboard** or **smartdashboard** 
- For this section of our tutorial we will be adding switch and encoder data to **shuffleboard**

## Creating the Telemetry Subsystem

!!! summary ""
    **1)** Create a new **Subsystem** called **Telemetry**
    
!!! summary ""
    **2)** Create a constructor for the **Telemetry** class
    
    - The constructor is where we will create buttons for shuffleboard
    
!!! summary ""
    **3)** Inside type: 
    
    ```java
    SmartDashboard.putData(“Reset Drive Encoder”, new DriveResetEncoder());
    ```
       
!!! summary ""
    **4)** Create a public method called update
    
    - This method will run periodically in Robot.java to update sensor data on shuffleboard
    
!!! summary "" 
    **5)** Inside type: 
    
    ```java 
    SmartDashboard.putNumber(“Drivetrain Encoder Count”, Robot.m_drivetrain.getDriveEncoderCount());
    ```
       
!!! summary ""
    **6)** Do the same for the **getDriveEncoderDistance** method
    
!!! summary ""
    **7)** Try adding the **Shooter** Subsystem commands and sensor methods where they should be
    
??? Example 

	Your full **Telemetry.java** should look like this
	
	```java
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
  	```
	   
## Adding The Telemetry Subsystem to Robot.java

!!! summary ""
    **1)** When adding **Telemetry** to **Robot.java**, in **robotInit** we must add **Telemetry** after the other subsystems
  
    - This is because the **Telemetry** subsystem relies on methods that are created in other subsystems before it
    - It can be added before or after **OI** since they don’t use methods from each other

    <!-- TODO: Explain why we don't put it in robotPeriodic -->

!!! summary ""

    **2)** It is **important** that we add the **update** method to **disabledPeriodic, autonomousPeriodic**, and **teleopPeriodic** so that the **Shuffleboard** is always being updated with information on our sensors.

??? Example

	The code you typed before **robotInit** should be this
	
	```java
	public static Telemetry m_telemetry; 
	```
	  
	The code you typed in **robotInit** should be this
	
	```java
	m_telemetry = new Telemetry(); //This must be initialized after all other robot subsystems
	```
	   
	The code you typed in **disabledPeriodic, autonomousPeriodic**, and **teleopPeriodic** should be this
	
	```java
	Robot.m_telemetry.update();
	```
	   
## Testing Shuffleboard

<!-- TODO: Add pictures for this section -->

- After saving and deploying code, open the driver station
- Click the gear on the left side and configure your team number and set the dashboard type to “ShuffleBoard”
- If you are still connected to the robot you should see boxes for the buttons and data we added in Telemetry

## Using Shuffleboard

<!-- TODO: Add information and pictures on how to use tabs, group widgets together, saving layouts, etc -->
