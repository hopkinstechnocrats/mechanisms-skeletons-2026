package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class hopperSubsystem extends SubsystemBase{
    WPI_TalonSRX hopperFeederMotor;
    
    public hopperSubsystem(){
        hopperFeederMotor = WPI_TalonSRX();
        

        
    }

}
