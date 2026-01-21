package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.hopperSubsystem;

public class hopperCommands {
    public static Command hopperConveyorSpin(hopperSubsystem ConveyorSpin){
        return Commands.run(
                () -> {
                    hopperSubsystem.hopperConveyorSpeed();
                },
            hopperSubsystem);
    }
    public static Command hopperFeederForwards(EndEffectorSubsystem endEffector){
        return Commands.run(
                () -> {
                    endEffector.moveToSetpoint();
                },
            endEffector);
    }
     public static Command hopperFeederForwards(EndEffectorSubsystem endEffector){
        return Commands.run(
                () -> {
                    endEffector.moveToSetpoint();
                },
            endEffector);
    }
}
