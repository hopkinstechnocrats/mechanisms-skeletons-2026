package frc.robot.subsystems;
import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.TunableNumber;

public class IntakeSubsystem extends SubsystemBase{

 	NetworkTableInstance inst;
  	NetworkTable table;
  	DoubleEntry IntakePIDDifference; 
	DoubleEntry IntakeMotorVoltage; 
  	TalonFX m_intakeMotor;
	Slot0Configs m_intakeConfig;
    MotorOutputConfigs m_intakeOutputConfig;
    TunableNumber kPInputIntake;
    TunableNumber kIInputIntake;
    TunableNumber kDInputIntake;
    final VelocityVoltage m_intakeRequest = new VelocityVoltage(0).withSlot(0);

    TalonFX intakeMotor;

        public IntakeSubsystem(){
            inst = NetworkTableInstance.getDefault();
            table = inst.getTable("Intake Info");

            kPInputIntake = new TunableNumber("/Tunable Numbers/kPInput Intake", Constants.IntakeConstants.k_intakeP);
            kIInputIntake = new TunableNumber("/Tunable Numbers/kIInput Intake", Constants.IntakeConstants.k_intakeI);
            kDInputIntake = new TunableNumber("/Tunable Numbers/kDInput Intake", Constants.IntakeConstants.k_intakeD);

            m_intakeMotor = new TalonFX(Constants.IntakeConstants.k_intakeMotorCANID); //Need to getCANID
            m_intakeConfig = new Slot0Configs();
            m_intakeOutputConfig = new MotorOutputConfigs();
            m_intakeConfig.kP = Constants.IntakeConstants.k_intakeP;
            m_intakeConfig.kI = Constants.IntakeConstants.k_intakeI;
            m_intakeConfig.kD = Constants.IntakeConstants.k_intakeD;
			m_intakeConfig.kV = Constants.IntakeConstants.k_feedForward;
            m_intakeMotor.getConfigurator().apply(m_intakeConfig);

            IntakeMotorVoltage = table.getDoubleTopic("Intake Motor Volated").getEntry(0);
            IntakePIDDifference = table.getDoubleTopic("Intake PID Difference").getEntry(0);
        }
    
		@Override
    	public void periodic(){
      		IntakePIDDifference.set(m_intakeMotor.getClosedLoopError().getValueAsDouble()); 
     		//difference between desired state and real state as a double
			IntakeMotorVoltage.set(m_intakeMotor.getMotorVoltage().getValueAsDouble());

            if(DriverStation.isTestEnabled() && kPInputIntake.hasChanged(hashCode())){
                m_intakeConfig.kP = kPInputIntake.getAsDouble();
                m_intakeMotor.getConfigurator().apply(m_intakeConfig);
            }

            if(DriverStation.isTestEnabled() && kIInputIntake.hasChanged(hashCode())){
                m_intakeConfig.kI = kIInputIntake.getAsDouble();
                m_intakeMotor.getConfigurator().apply(m_intakeConfig);
            }

            if(DriverStation.isTestEnabled() && kDInputIntake.hasChanged(hashCode())){
                m_intakeConfig.kD = kDInputIntake.getAsDouble();
                m_intakeMotor.getConfigurator().apply(m_intakeConfig);            
            }
    	}

        public void intake(double intakeSpeed){
        	m_intakeMotor.setControl(m_intakeRequest.withVelocity(intakeSpeed));
        }

        public void intakeBrake(){
        	m_intakeMotor.setControl(m_intakeRequest.withVelocity(Constants.IntakeConstants.k_intakeBrakeSpeedRPS));
        }
}
