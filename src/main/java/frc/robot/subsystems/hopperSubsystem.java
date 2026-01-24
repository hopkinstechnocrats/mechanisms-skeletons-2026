package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class hopperSubsystem extends SubsystemBase{
    TalonFX hopperFeederMotor;
    static TalonFX hopperConveyorMotor;
    public hopperSubsystem(){
        hopperFeederMotor = new TalonFX(Constants.hopperFeederCANID);
        hopperConveyorMotor = new TalonFX(Constants.hopperConveyorCANID);

        hopperFeederMotor.setNeutralMode(NeutralModeValue.Brake);
        hopperConveyorMotor.setNeutralMode(NeutralModeValue.Brake);

    }
    public static void hopperConveyorSpin(double conveyorSpeed){
            hopperConveyorMotor.set(conveyorSpeed);
    }
    public void hopperFeederSpinForwards(double feederSpeed){
            hopperConveyorMotor.set(feederSpeed);
    }
    public void hopperFeederSpinBackwards(double feederSpeed){
        hopperConveyorMotor.set(-feederSpeed);
    }
    }

