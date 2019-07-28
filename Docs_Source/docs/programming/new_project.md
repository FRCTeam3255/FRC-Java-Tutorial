# **WIP** Creating Project Files

Lets get started

![VSCode](../assets/images/logos/code.png){height=150px}	![](../assets/images/logos/wpilib.png){height=150px}

## Overview

Before we can start progrmming a robot, we must create a new project in Visual Studio Code (VSCode). This section will go over:

- [Creating a New Project](#creating-a-new-project)
- [Creating a New Subsystem](#creating-a-new-subsystem)
- [Creating a New Command](#creating-a-new-command)

## Creating a New Project

!!! summary ""
	1) Select the **W icon** from the tab bar or use the shortcut by holding down **Ctrl+Shift+P** at the same time. (Replace ctrl with command on macOS)  
	
	![](../assets/images/new_project/project/step_1.png)

!!! summary ""
	2) Type and hit enter or select **WPILib: Create a new project**
	
	![](../assets/images/new_project/project/step_2.png)

!!! summary ""
	3) Click **Select a Project Type** and choose **Template**  
	4) Click **Select a Language** and choose **Java**  
	5) Click **Select a project base** and choose **Command Robot**  
	
	![](../assets/images/new_project/project/step_3.png)

!!! summary ""
	6) Click **Select a new project folder** and choose where on your computer you would like to store the program
	
	![](../assets/images/new_project/project/step_4.png)

!!! summary ""
	7) **Enter a project name** in the text field labeled as such  
	8) **Enter your team number** in the text field labeled as such  
	9) Select **Generate Project**  
	
	![](../assets/images/new_project/project/step_5.png)

!!! summary ""
	1)  When prompted **“Would you like to open the folder?”**, select **Yes (Current Window)**
	
	![](../assets/images/new_project/project/step_6.png)

### Default Project Contents

## Creating a New Subsystem

!!! summary ""
	1) Double click on the **src** folder to expand it.  
	2) Do the same for **subsystems**
	
	![](../assets/images/new_project/subsystem/step_1.png)

!!! summary ""
	3) Right click on **subsystems** and select **Create a new class/ command.**
	
	![](../assets/images/new_project/subsystem/step_2.png)
	
!!! summary ""
	4) Select **Subsystem** and type your **DesiredSubsystemName** (i.e. **Drivetrain**) for the name and hit enter on your keyboard.
	
	![](../assets/images/new_project/subsystem/step_3.png)  
	![](../assets/images/new_project/subsystem/step_4.png)

!!! summary ""
	5) Click on the newly create **DesiredSubsystemName.java** (or **Drivetrain.java** if you named it that)
	
	![](../assets/images/new_project/subsystem/step_5.png)

***

### Adding the Subsystem to Robot.java

!!! warning "Do not forget this step!"
	When a robot program runs on the roboRIO it only runs the main file Robot.java and anything Robot.java links to.  
	We have created a new subsystem but we have not yet linked it to Robot.java.  

	!!! danger "***We must do this for EVERY subsystem we create***"

!!! summary ""
	1) In Robot.java we will create a new **global** variable of type `DesiredSubsystemName` (i.e. `Drivetrain`) named `#!java m_desiredSubsystemName` (`i.e. m_drivetrain`) and set its value to `null`.  
    
	![](../assets/images/new_project/project/step_1.png)

!!! summary ""
	2) In the `robotInit()` method add: `#!java m_desiredSubsystemName = new DesiredSubsystemName();` (i.e. `#!java m_drivetrain = new Drivetrain();`)
    
	!!! warning "Important"
    	This must always be done above **OI** and **Telemetry/SmartDashboard** (if present).

	![](../assets/images/new_project/project/step_1.png)
	
Now when we use this subsystem in commands, we must call `#!java Robot.m_desiredSubsystemName.` to get access to it and its methods. (i.e. `#!java Robot.m_drivetrain.someMethod()`)

### Default Subsytem Contents

- Newly created subsystems are empty with the exception of the initDefaultCommand.
- We will create a constructor ourselves later.
- initDefaultCommand - a command that will run automatically every time the subsystem is called.
    - When another command that requires the same subsystem is called, the initDefaultCommand will stop and restart after the new command has finished.
        - This process calls the interrupted method of the command being called initDefaultCommand

!!! Example  
    ![](../assets/images/new_project/new_subsystem.png)

## Creating a New Command

!!! summary ""
	1) Double click on the **src** folder to expand it.  
	2) Do the same for **commands**
	
	![](../assets/images/new_project/command/step_1.png)

!!! summary ""
  	3) Right click on **commands** and select **Create a new class/ command.**  
	
	![](../assets/images/new_project/command/step_2.png)

!!! summary ""
	4) Select **Command** and type **DesiredCommandName** (i.e. DriveArcade) for the name and hit enter on your keyboard.  
	
	![](../assets/images/new_project/command/step_3.png)  
	![](../assets/images/new_project/command/step_4.png)

!!! summary ""
    5) Click on the newly create **DesiredCommandName.java** (or **DriveArcade.java** if you named it that)
	
	![](../assets/images/new_project/command/step_5.png)

### Default Command Contents

- **Constructor** - Called when the robot program is ***FIRST*** loaded.
    - Subsystem dependencies are declared here.
- **Initialize** - Called ***ONCE*** just before this Command runs the first time.
- **Execute** - Called ***REPEATEDLY*** when this Command is scheduled to run
- **isFinished** - Make this return ***TRUE*** when this Command no longer needs to run `execute()` (initialize always runs once regardless). 
- **End** - Called ***ONCE*** after isFinished returns true
- **Interrupted** - Called when ***another command*** which requires one or more of the same subsystems is scheduled to run

??? Example
    ```java
  	package frc.robot.commands;

    import edu.wpi.first.wpilibj.command.Command;

    public class ArcadeDrive extends Command {
      public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
        return false;
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
