package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick driverController = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);

  Button D1 = new JoystickButton(driverController, 1);
  Button D2 = new JoystickButton(driverController, 2);
  Button D3 = new JoystickButton(driverController, 3);
  Button D4 = new JoystickButton(driverController, 4);
  Button D5 = new JoystickButton(driverController, 5);
  Button D6 = new JoystickButton(driverController, 6);
  Button D7 = new JoystickButton(driverController, 7);
  Button D8 = new JoystickButton(driverController, 8);
  Button D9 = new JoystickButton(driverController, 9);
  Button D10 = new JoystickButton(driverController, 10);

  public OI() {
    D1.whenPressed(new ShooterUp());
    D2.whenPressed(new ShooterDown());
    D3.whenPressed(new ShooterUpAuto());
  }
}
