package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.hopperSubsystem;
import frc.robot.Constants;

public class hopperCommands {
    public static Command hopperConveyorSpin(hopperSubsystem ConveyorSpin){
        return Commands.run(
                () -> {
                    hopperSubsystem.hopperConveyorSpin(Constants.conveyorSpeed);
                },
            ConveyorSpin);
    }
    public static Command hopperFeederForwards(hopperSubsystem FeederForwards){
        return Commands.run(
                () -> {
                    hopperSubsystem.hopperFeederSpinForwards(Constants.feederSpeed);
                },
            FeederForwards);
    }
     public static Command hopperFeederBackwards(hopperSubsystem FeederBackwards){
        return Commands.run(
                () -> {
                    hopperSubsystem.hopperFeederSpinBackwards(Constants.feederSpeed);
                },
            FeederBackwards);
    }
}
