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
