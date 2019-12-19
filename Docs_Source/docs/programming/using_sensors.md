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
- Unlike potentiometers their shafts can continuously rotate and count infinitely* positive or negative.\

## Setting Up Switches

!!! summary ""
    **1)** For this tutorial we are going to add a switch to the shooter subsystem to automatically change the pitch of the shooter
    
    - Inside the shooter subsystem we are going to create a switch called shooterSwitch
    - It will be created as a DigitalInput.
    - The DigitalInput constructor only takes 1 parameter - (new DigitalInput(port)
    - The port refers to the port numbers on the RoboRIO’s DIO
    - Store the port in RobotMap
    
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
	
	
