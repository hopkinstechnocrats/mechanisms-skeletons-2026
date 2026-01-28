package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


    public class LauncherSubsystem extends SubsystemBase{
        TalonFX m_launcherMotor;
          Slot0Configs m_launcherConfig;
        MotorOutputConfigs m_launcherOutputConfig;
         final VelocityVoltage m_launcherRequest = new VelocityVoltage(0).withSlot(0);
        public LauncherSubsystem(){
            m_launcherMotor = new TalonFX(Constants.launcherMotorCANID); //Need to getCANID
            m_launcherMotor.setNeutralMode(NeutralModeValue.Brake);
             Slot0Configs m_intakeConfig = new Slot0Configs();
            m_launcherOutputConfig = new MotorOutputConfigs();
            m_launcherConfig.kP = Constants.k_launcherP;
            m_launcherConfig.kI = Constants.k_launcherI;
            m_launcherConfig.kD = Constants.k_launcherD;
            m_launcherOutputConfig.NeutralMode = NeutralModeValue.Brake;
            m_launcherMotor.setNeutralMode(NeutralModeValue.Brake);
            m_launcherMotor.getConfigurator().apply(m_intakeConfig);
        }
    
        public void launcher(double launcherSpeed){
          m_launcherMotor.setControl(m_launcherRequest.withVelocity(10));
        }
    }

