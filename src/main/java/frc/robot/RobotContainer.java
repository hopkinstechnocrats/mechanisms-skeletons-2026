// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.robot.subsystems.launcherSubsystem;
import frc.robot.commands.launcherCommands;

public class RobotContainer {

    CommandXboxController driveController = new CommandXboxController(Constants.ControlConstants.k_driverPort);
    private final launcherSubsystem launcherSubsystem = new launcherSubsystem();
    private final CommandXboxController operatorController = new CommandXboxController(Constants.ControlConstants.operatorXboxControllerPort);

    public RobotContainer() {
		launcherSubsystem.setDefaultCommand(
            new RunCommand(
                    () -> {
                    launcherSubsystem.launcherBrake();
                  }, launcherSubsystem
      ));

      configureButtonBindings();
    }


      

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }

   

    private void configureButtonBindings() {
        operatorController.a().whileTrue(launcherCommands.launcher(launcherSubsystem));
        operatorController.b().whileTrue(launcherCommands.reverseLauncher(launcherSubsystem));

  }
}
