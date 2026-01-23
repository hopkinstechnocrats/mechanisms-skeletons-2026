package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberCommands extends Command {

    public static Command climber(ClimberSubsystem wheel) {
        return Commands.run(
            () -> {
                wheel.climber(Constants.climberSpeed);
            },
        wheel);
        
    }
    public static Command unclimber(ClimberSubsystem wheel) {
        return Commands.run(
            () -> {
                wheel.climber(Constants.reverseClimberSpeed);
            },
        wheel);
        
    }
}