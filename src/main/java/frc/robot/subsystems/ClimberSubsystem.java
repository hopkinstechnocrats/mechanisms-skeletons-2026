package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class ClimberSubsystem extends SubsystemBase {
    TalonFX climberMotor;
    public ClimberSubsystem(){
        climberMotor = new TalonFX(Constants.climberMotorCANID);
        climberMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public void climber(double climberSpeed){
        climberMotor.set(climberSpeed);
    
    }
}