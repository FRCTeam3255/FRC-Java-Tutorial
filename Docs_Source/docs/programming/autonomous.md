# **WIP** Creating an Autonomous Command

<!-- ![Image Title](imageURL)

## Overview

In this section we will be going over

1. Creating an autonomous command group
2. Using RobotPreferences to quickly change our autonomous values
3. Using an encoder to autonomously drive
4. Creating a delay timer to pace our commands in autonomous

***

## What Is an Autonomous Command

- An autonomous command is a command that is ran during "autonomous mode" under the **autonomousInit** method in **Robot.java** 
- It could be a single command or a command group
- It's especially helpful to have if you don't have any cameras to drive the robot during a 
"sandstorm" period (2019 game mechanic where the drivers couldn't see during the pre tele-op phase)

## Creating Commands For Autonomous

- Since we can't control our robot during an autonomous command we will want to create commands that allow the robot to move independently of a driver

## Creating the DriveDistance Command 

!!! summary ""
    **1)** Create a new command called **DriveDistance**
    
!!! summary ""
    **2)** Before the constructor create a **double** called **distance**
    
    - We will use this to tell the command to finish when the robot drives the inputed distance
    
!!! summary ""
    **3)** In the **DriveDistance** constructor add a **double** parameter called **inches**
    
!!! summary ""
    **4)** Inside type:
    
        '''java
        distance = inches;
           '''
        
!!! summary ""
    **5)** In **initialize** add our **resetDriveEncoder** method
    
    - We want to reset the encoder before we drive so that it counts the distance from zero
    
!!! summary ""
    **6)** In **execute** add our **arcadeDrive** method and change the **moveSpeed** parameter to a **RobotPreference** named **driveDistanceSpeed** and **rotateSpeed** to 0.0
    
    - We only want to drive the robot forward; a **RobotPreference** will help us tune the drive speed
    
!!! summary ""
    **7)** In **isFinished** type:
    
        '''java
        return Robot.m_drivetrain.getDriveEncoderDistance() == distance;
           '''
!!! summary ""
    **8)** In **end** stop the **Drivetrain** and call **end** in **interrupted**
    
??? Example
    
        Your full **DriveDistance.java** should look like this
        
        '''java
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

    

