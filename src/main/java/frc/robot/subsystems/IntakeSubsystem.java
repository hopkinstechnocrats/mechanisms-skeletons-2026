package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


    public class IntakeSubsystem extends SubsystemBase{
        TalonFX intakeMotor;
        public IntakeSubsystem(){
            intakeMotor = new TalonFX(Constants.intakeMotorCANID); //Need to getCANID
            intakeMotor.setNeutralMode(NeutralModeValue.Brake);
        }
    
        public void intake(double intakeSpeed){
            intakeMotor.set(intakeSpeed);
        }
    }

