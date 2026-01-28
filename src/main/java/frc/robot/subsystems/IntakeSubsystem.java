package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



    public class IntakeSubsystem extends SubsystemBase{
        TalonFX m_intakeMotor;
        Slot0Configs m_intakeConfig;
        MotorOutputConfigs m_intakeOutputConfig;
        final VelocityVoltage m_intakeRequest = new VelocityVoltage(0).withSlot(0);

        public IntakeSubsystem(){
            m_intakeMotor = new TalonFX(Constants.intakeMotorCANID); //Need to getCANID
            Slot0Configs m_intakeConfig = new Slot0Configs();
            m_intakeOutputConfig = new MotorOutputConfigs();
            m_intakeConfig.kP = Constants.k_intakeP;
            m_intakeConfig.kI = Constants.k_intakeI;
            m_intakeConfig.kD = Constants.k_intakeD;

            m_intakeOutputConfig.NeutralMode = NeutralModeValue.Brake;
            
            m_intakeMotor.setNeutralMode(NeutralModeValue.Brake);

            m_intakeMotor.getConfigurator().apply(m_intakeConfig);
        }
    
        
        public void intake(double intakeSpeed){
            m_intakeMotor.setControl(m_intakeRequest.withVelocity(10));
        }
    }

