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

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.IntakeCommands;

public class RobotContainer {

    CommandXboxController driveController = new CommandXboxController(Constants.ControlConstants.k_driverPort);
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    private final CommandXboxController operatorController = new CommandXboxController(Constants.ControlConstants.operatorXboxControllerPort);

    public RobotContainer() {
		intakeSubsystem.setDefaultCommand(
            new RunCommand(
                    () -> {
                    intakeSubsystem.intakeBrake();
                  }, intakeSubsystem
      ));

      configureButtonBindings();
    }


      

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }

   

    private void configureButtonBindings() {
        operatorController.a().whileTrue(IntakeCommands.intake(intakeSubsystem));
        operatorController.b().whileTrue(IntakeCommands.reverseIntake(intakeSubsystem));

  }
}
