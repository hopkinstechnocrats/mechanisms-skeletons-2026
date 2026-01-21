package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


    public class LauncherSubsystem extends SubsystemBase{
        TalonFX launcherMotor;
        public LauncherSubsystem(){
            launcherMotor = new TalonFX(Constants.launcherMotorCANID); //Need to getCANID
            launcherMotor.setNeutralMode(NeutralModeValue.Brake);
        }
    
        public void launcher(double launcherSpeed){
            launcherMotor.set(launcherSpeed);
        }
    }

