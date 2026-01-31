package frc.robot.subsystems;
 
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import frc.robot.Constants;


public class FeederSubsystem extends SubsystemBase {
    TalonFX feederMotor;
    public FeederSubsystem(){
        feederMotor = new TalonFX(Constants.feederMotorCANID);
        feederMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public void feeder(double feederSpeed){
        feederMotor.set(feederSpeed);
    
    }
}
