# Java Programming Basics

Learning What's What

![Java](../assets/images/logos/java.png)

## Overview

- Objects, variables, and classes (in Java) make up our programs. We define, modify, use these variables and objects to make our programs run.
- Programs use key words to define characteristics of variables or objects. Basic keywords:
    - `#!java public` - an object accessible by other classes (files)
    - `#!java private` - an object only accessible by its containing class (file).
    - `#!java protected` - like private but can be seen by subclasses
    - `#!java return` - value to return or give back after method execution (run). void - a method that returns no value

!!! Warning "IMPORTANT NOTE"
	Java is case sensitive, meaning capitalization matters!
***

## Classes

- Classes are the files that contain our programming
- A program can be made up of one class but can also be made up of many classes
    - All programs run a main class that can optionally load additional classes either directly or indirectly 
    - !!! example
    	main loads class1, class1 loads class2
- Classes are made up of variables and methods and are often used to separate and organize your code.
- Classes can also **call** (use) variables or methods of other classes if those have been set to public.

### Constructors

- Classes can also have a ***constructor*** which is a special type of **method** that has the **same name (case sensitive)** as the class file
    - Constructors are always called when the class is loaded into the program for the first time. This is often the only time they are called.
    - Constructors are called when trying to access the class in other files.
    - They can be called again if the class is programmed to be unloaded (destroyed) and reloaded.
    - Calls to methods, and assignment of values, within the constructor will run as soon as the class is called (loaded) in the code.

***

## Methods

- Methods, also known as functions, can be thought of as subprograms or routines that run inside of your main program.
- Methods are used when you want to run the same code multiple times. Copying and pasting code is ***BAD!*** Use methods instead!
- Methods are also useful to access only certain parts or functions of another class.
- Methods can also have their own variables (**local**) or use variables available throughout the whole class (**global variables**), this will be explained more in the [scope section](#scope).
- Methods can call (use) other methods, even multiple times.

!!! example
	```java
	int value;
    void increment(){
		value++;
	}
	```

### Parameters

- Parameters are variables that are passed (sent) to a method for it to use.
- You can pass more than one parameter but order matters when calling the method.

!!! example
	```java
    // Example of a method with a parameter
    double half(int num1){ 
        double multiplier = 0.5;
        return num1*multiplier; 
    }

    int newNumber = half(12); // <---- Method being called (used) in code
	```

***

## Variables

- Variables are objects that contain data, they are characterized by data types
- Variables are assigned names and data types on creation
    - Names can be anything with the exception of pre-existing keywords such as `public` or `int`
- Data types define what type of data is being stored in the variables:
    - `#!java int` - integers (whole numbers)
    - `#!java double` - double precision floating point (fractional/decimal values) 
    - `#!java boolean` - true or false (true = 1 or false = 0) values.
    - `#!java string` - text values contained in parentheses
    - !!! Example "Example: `#!java int sum;`"
    	A variable that can hold whole number values
	- !!! Example "Example: `#!java boolean isFull = true;`"
    	A variable can either hold a true or false value and is being assigned a true value

- Most non-static variables can have their values assigned or assigned at any point elsewhere in your program
  
### Scope

- When creating a variable, where you create it matters. This is known as the scope of a variable.
- The scope is where a variable can be seen within a class
    - A variable created in a method can only be seen in that method. This is a local variable.
    - A variable created outside a method can be seen in all methods of that class (file). This is a global variable.
        - It is good practice to put them all at the top before your first method.

!!! example "Example of a Local Variable"
	```java
    public int testMethod() {
        int example = 12; // Instide of method
        example = example + 1;
        return example
    }
	```    

!!! example "Example of a Public Variable"
	```java
    int example = 12; // Outside of method
    public void testMethod() {
        example = example + 1;
        return example
    }
	```
***

## Comments

- Comments are a programmer-readable explanation or annotation in the source code of a program.
- Comments do not affect what the code does.
- Comments are often used to leave notes or explanations of what methods or classes are doing so that it is easier to understand the code.

!!! example "Example: Single Line Comments"
	```java
    // This is what a single line comment looks like

    // You can also have multiple
    // single line comments in a row
    ```

!!! example "Example: Multi Line Comments"
	```java
    /* 
    This is what a
    multiline comment
    looks like 
    */
    ```

!!! example "Example: Doc Comments"
	```java
    /**
     * This is a doc comment
     * 
     * <ul>
     * <li>They can be viewed by hovering over code they are attached to</li>
     * <li>They can be formatted with HTML</li>
     * </ul>
    */
	```

***

## Conventions

- There are also many different conventions when programming, this ensures that programs are readable between different people.
- A common naming convention:
    - Programming is often done in CamelCase or lowerCamelCase
    - Instead of adding spaces, capitalize the first letter of each word 
    - !!! example
        ThreeMotorDrive, driveForward, setSpeed

!!! info  
    There are other naming conventions, but for this tutorial we will use the camel cases
