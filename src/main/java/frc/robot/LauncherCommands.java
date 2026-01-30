package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.LauncherSubsystem;

public class LauncherCommands extends Command {
    
    public static Command launcher(LauncherSubsystem wheel) {
        return Commands.run(
            () -> {
                wheel.launcher(Constants.launchSpeed);
            },
        wheel);
    }
     public static Command launcherBreak(LauncherSubsystem wheel){
        return Commands.run(
            () -> {
                wheel.launcherBrake(0);
            },
            wheel);
    }
}