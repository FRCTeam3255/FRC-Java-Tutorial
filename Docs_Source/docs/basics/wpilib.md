# WPILib Programming Basics

Making FRC Programming Easy

![WPI Lib](../assets/images/wpilib.png)

## What is WPILib

- The WPI Robotics library (WPILib) is a set of software classes that interfaces with the hardware and software in your FRC RoboRIO.
    - There are classes to handle sensors, motor speed controllers, the driver station, and a number of other utility functions.
- Documentation is available at <http://first.wpi.edu/FRC/roborio/release/docs/java>
- WPILib adds those sensors and controllers as additional data types (like `int` or `double`) and classes.
    - !!!example "Examples" 
  		`Talon`, `Solenoid`, `Encoder`...

***

## Command Based Robot

- For our programming tutorial we will be creating a Command based robot
- Command Based Robots are much like Legos, with very basic pieces you can make something **simple** like a house or **complicated** like a replica Star Wars Millennium Falcon
- A command based robot is broken down into **subsystem** classes and **command** classes.
- In the code, a command based robot is made up of 3 **packages** (**folders**) labeled robot, commands, and subsystems
- There are other types of robots but we will use Command Based

***

## Subsystems

- A **subsystem** is a special template class made by FRC. 
- In robotics, subsystems are sections of the whole robot.
    - For example every FRC robot has a **Drivetrain** subsystem which is what controls the robot’s driving both physically and programmatically.
        - To avoid confusion between software and mechanical teams, subsystems should be called the same thing. If we have a ball intake system, we will both call it **Intake** or **Collector**.
    - Subsystems of a robot can contain parts to control or read data from.
        - The **Drivetrain** subsystem could contain **motor controllers** and **encoders** both physically and programmatically.
- Using a dog as an example: the **legs**, **tail**, and **head** are **subsystems**.
    - The **head** subsystem has the parts: **eyes**, **ears**, and **nose**.
- When programming subsystems we use variables and methods to tell our subsystem what it has and what it is capable of or should do.
    - These variables will be the parts in the subsystem
    - These methods will define what those parts are capable of. 
- Using a dog **head** subsystem as an example:
    - Some variables (parts) would be: **leftEye**, **rightEye**, **nose**, **leftEar**, **rightEar**.
    - Some example methods would be **closeEyes** or **openEyes** since these are things the dog are capable of.
        - These methods would use both the **leftEye** and **rightEye** and close them.
    - !!! example
    	```java
    	//This method closes the dog eyes
        public void closeEyes(){
    		leftEye.close();
    		rightEye.close();
    	```
- A robot example of a **Drivetrain** subsystem would have **leftMotor**, and **rightMotor** as variables and **setSpeed** as a method telling it how to set the speed of those motor controllers.
- Having the **setSpeed** method tells our program that our **Drivetrain** subsystem can set its speed.
    - !!! example
    	```java
		//This method sets the speed of the drivetrain
		public void setSpeed(double speed){
			leftMotor.set(speed);
			rightMotor.set(speed);
		}
    	```

***

## Commands

- A **command** is a special template class (file) made by FRC.
- In robotics, commands are actions you want a robot to do (just like a real life command).
    - A **command** is an action a **subsystem(s)** performs.
    - For example you may want your robot to drive full speed forward so you make a command class called **DriveForward**.
        - Since a robot uses a **Drivetrain** subsystem to control its motors, this command would call our previously created **setSpeed** method from that subsystem.
- !!! Tip 
	**Subsystems** define what the robot is made of and what it can do while **commands** actually tell the robot to do those things
- Using a dog as an example we can tell the dog to blink by creating a **BlinkEyes** command
    - The command would call the method, **closeEyes()** then the method **openEyes()**
