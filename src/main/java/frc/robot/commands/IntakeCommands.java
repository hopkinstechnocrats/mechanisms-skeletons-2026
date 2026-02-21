package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommands extends Command {
       
    public static Command intake(IntakeSubsystem wheel) {
        return Commands.run(
            () -> {
                wheel.intake(Constants.IntakeConstants.k_intakeSpeedRPS);
            },
        wheel);
    }
    public static Command reverseIntake(IntakeSubsystem wheel) {
        return Commands.run(
            () -> {
                wheel.intake(Constants.IntakeConstants.k_reverseIntakeSpeedRPS);
            },
        wheel);
    }
}
