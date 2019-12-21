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

    public static final double driveDistanceSpeed() {
        return Preferences.getInstance().getDouble("driveDistanceSpeed", 0.5);
    }

    // Autonomous
    public static double autoDelay() {
        return Preferences.getInstance().getDouble("autoDelay", 5.0);
    }

    public static double autoDriveDistance() {
        return Preferences.getInstance().getDouble("autoDriveDistance", 12.0);
    }

}
