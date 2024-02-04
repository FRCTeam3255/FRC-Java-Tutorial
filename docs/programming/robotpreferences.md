# [WIP] Using RobotPreferences

<!-- ![Image Title](imageURL)  -->

## Overview

In this section we will be going over

1. Creating and using RobotPreferences in shuffleboard
2. How to convert encoder counts to inches

***

## What Are RobotPreferences

- On SmartDashboard or ShuffleBoard there is a widget called Robot Preferences that can store variables that can be quickly changed
- For example you might have a variable that changes PID values which can be changed from Robot Preferences on SmartDashboard/ShuffleBoard
- For this section of our tutorial we will create a robot preference called driveEncoderCountsPerFoot

## Creating RobotPreferences

!!! summary "" 
    **1)** Create a new **empty class** called **RobotPreferences**
    
    - This is where we store all of our **RobotPreferences** to access anywhere
    - If we want to use a **RobotPreference** we call RobotPreferences.preferenceName()

!!! summary "" 
    **2)** Inside the constructor type:
    
	```java 
	public static double driveEncoderCountsPerFoot(){
	  return Preferences.getInstance().getDouble(“driveEncoderCountsPerFoot”, 1.0);
	}
	```
   
    - The format for creating a RobotPreference is
    
	```java
	public static variableType preferenceName(){
	  return Preferences.getInstance().getVariableType("preferenceName", value);
	```
	   
??? Example
	
	Your full **RobotPreferences.java** should look like this
	
	```java
	package frc.robot;

	import edu.wpi.first.wpilibj.Preferences;

	/**
 	* Add your docs here.
 	*/
	public class RobotPreferences {
    	  // Drivetrain
    	  /**
     	  * Default value is 1.0
     	  */
    	  public static double driveEncoderCountsPerFoot() {
            return Preferences.getInstance().getDouble("driveEncoderCountsPerFoot", 1.0);
    	  }

	}
	```
	   
## Creating getDriveEncoderDistance Method

- We will use this **RobotPreference** to help us create a method that can keep track of the distance our robot has driven in inches

!!! summary ""
    **1)** Create a method called **getDriveEncoderDistance** inside of **Drivetrain**
    
!!! summary ""
    **2)** Inside type:
    
    ```java
	return (getDriveEncoderCount() / RobotPreferences.driveEncoderCountsPerFoot()) * 12;
	```
     
    - This will divide the current encoder count by however many counts there are in a foot then multiply that number by 12 to give us the encoder distance in inches
    
!!! Note
    You may need to invert this value if your encoder counts backward when the robot is driving forward
    
!!! Example

	The code you typed should be this
	
	```java
	public double getDriveEncoderDistance() {
   	 return (getDriveEncoderCount() / RobotPreferences.driveEncoderCountsPerFoot()) * 12;
  	}
	```
	  
!!! summary ""
    **3)** Add the method to the **update** method in **Telemetry**
    
## Using RobotPreferences

<!-- TODO: Explain in more detail how to add RobotPreferences and add pictures -->

- After deploying the code to your robot find the **RobotPreferences** widget and add it to your page
- Click the add button and enter the **string** of the **RobotPreference** and its type (doubles and ints are numbers)
- If you double click on the preference value you will notice that you can change its value
- If you change a preference value it will update **immediately**

!!! Tip 
    If you want to save your robot preference values that you've changed make sure you hardcode them in **RobotPreferences.java** later or take a picture if you want to use them again later
    
## Measuring Distance Using Encoders

- Right now the encoders tell us distance in terms of encoder counts
- We will use our **driveEncoderCountsPerFoot** preference to save how many counts there are when the robot drives 1 foot

!!! summary ""
    **1)** Move the wheel on your robot with the **Drivetrain** encoder attached 1 foot or drive your robot 1 foot
    
!!! summary ""
    **2)** Read how many counts your encoder has in the **Drive Encoder Count** window
    
    - If you want to measure again press the **Reset Drive Encoder** command button to reset the **Drivetrain** encoder count
    
!!! summary ""
    **3)** Change the value of **driveEncoderCountsPerFoot** in the widget to this number
    
!!! summary ""
    **4)** Reset the **Drivetrain** encoder and move the wheel 1 foot or drive the robot 1 foot again
 
!!! summary ""
    **5)** Make sure your **Drive Encoder Distance** window reads approximately 12 (this is in inches)
    
    - If not repeat these steps again
    
!!! summary ""
    **6)** Save your **RobotPreferences** widget with this value
   
!!! summary ""
    **7)** Hardcode this value in **RobotPreferences.java** in the **driveEncoderCountsPerFoot** method incase you cannot recover your **RobotPreferences** save
