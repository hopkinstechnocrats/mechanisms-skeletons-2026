package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



    public class IntakeSubsystem extends SubsystemBase{
        TalonFX m_intakeMotor;
        TalonFX m_intakeDeployMotor;
        Slot0Configs m_intakeConfig;
        Slot1Configs m_intakeDeployConfig;
        MotorOutputConfigs m_intakeOutputConfig;
        MotorOutputConfigs m_intakeDeployOutputConfig;
        final VelocityVoltage m_intakeRequest = new VelocityVoltage(0).withSlot(0);

        public IntakeSubsystem(){
            m_intakeMotor = new TalonFX(Constants.intakeMotorCANID); //Need to getCANID
            m_intakeDeployMotor = new TalonFX(Constants.intakeDeployMotorCANID); //Also needs CANID
            Slot0Configs m_intakeConfig = new Slot0Configs();
            Slot1Configs m_intakeDeployConfig = new Slot1Configs();
            m_intakeOutputConfig = new MotorOutputConfigs();
            m_intakeConfig.kP = Constants.k_intakeP;
            m_intakeConfig.kI = Constants.k_intakeI;
            m_intakeConfig.kD = Constants.k_intakeD;
            m_intakeDeployOutputConfig = new MotorOutputConfigs();
            m_intakeDeployConfig.kP = Constants.k_intakeDeployP;
            m_intakeDeployConfig.kI = Constants.k_intakeDeployI;
            m_intakeDeployConfig.kD = Constants.k_intakeDeployD;
            m_intakeDeployConfig.kS = Constants.k_intakeDeployS;
            m_intakeDeployConfig.kV = Constants.k_intakeDeployV;


            m_intakeOutputConfig.NeutralMode = NeutralModeValue.Brake;
            m_intakeDeployOutputConfig.NeutralMode = NeutralModeValue.Brake;
            m_intakeMotor.setNeutralMode(NeutralModeValue.Brake);
            m_intakeDeployMotor.setNeutralMode(NeutralModeValue.Brake);
            m_intakeDeployMotor.getConfigurator().apply(m_intakeDeployOutputConfig);
            m_intakeMotor.getConfigurator().apply(m_intakeConfig);
        }
    
        
        public void intake(double intakeSpeed){
            m_intakeMotor.setControl(m_intakeRequest.withVelocity(10));
        }
    }

