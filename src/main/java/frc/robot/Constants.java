// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //TODO: update all variables ending in CANID

    //Popcorn Constants
    public static final double accelerationMotorTopSpeed = 0.85;
    public static final double loadingMotorTopSpeed = 0.4;
    public static final int popcornAcceleratorCANID = 10; //TODO: Put in the CANID's
    public static final int popcornLoaderCANID = 28; //TODO: Put in the CANID's


    //IntakeSubsystem Constants
    public static final int intakeMotorCANID = 13;//was 13
    public static final int winchMotorCANID = 1099;// was 10
    public static final double winchMotorTopSpeed = 1; //was 1
    public static final double butterIntakeTopSpeed = -0.3;    //was .6
    public static final double butterOuttakeTopSpeed = 1.0;    //was .6

    //PI be like...
    public static final double pi = 3.14;

    //the speed that the butter systems can run
    //UPDATE ME!!!!
    public static final double pullyLowerTime = 1;
    public static final double pullyRaiseTime = 1;

    // The CAN ID is the device ID of each sof the motors
    public static final int rightLeaderCANID = 8;
    public static final int rightFollowerCANID = 7;
    public static final int leftLeaderCANID = 5;
    public static final int leftFollowerCANID = 6;
    //The controller ports can be changed in driverstation
    public static final int driverXboxControllerPort = 0;
    public static final int operatorXboxControllerPort = 1;

    /* 
    Sets the maximum power we can drive at. 1.0 is 100%. 
    The number is negative because xbox controllers are down-right positve
    */
    public static final double maxMotorOutput = -0.8;

     public static final class FeederConstants{
        public static final int feederMotorCANID = 11;//change this
        public static final double feederSpeedRPS = .1;
        public static final double reverseFeederSpeedRPS = -.1;
        public static final double feederBreakSpeedRPS = 0;
        public static final double k_feederP = 0; 
        public static final double k_feederI = 0;
        public static final double k_feederD = 0;
        public static final double feederFeedForward = 0; 
    }
    
}