package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid pitchSolenoid = null;

  DigitalInput shooterSwitch = null;

  public Shooter() {
    pitchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID_DEPLOY, RobotMap.SHOOTER_PITCH_SOLENOID_RETRACT);

    shooterSwitch = new DigitalInput(RobotMap.SHOOTER_SWITCH);
  }

  public void pitchUp() {
    pitchSolenoid.set(Value.kForward);
  }

  public void pitchDown() {
    pitchSolenoid.set(Value.kReverse);
  }

  public boolean isShooterSwitchClosed() {
    return shooterSwitch.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
