package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


    public class LauncherSubsystem extends SubsystemBase{
        WPI_TalonSRX launcherMotor;
        public LauncherSubsystem(){
            launcherMotor = new WPI_TalonSRX(Constants.launcherMotorCANID); //Need to getCANID
            launcherMotor.configFactoryDefault();
            launcherMotor.setNeutralMode(NeutralMode.Brake);
        }
    
        public void launcher(double launcherSpeed){
            launcherMotor.set(launcherSpeed);
        }
    }

