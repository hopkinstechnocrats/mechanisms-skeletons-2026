package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {
    TalonFX turretMotor;
    public TurretSubsystem(){
        turretMotor = new TalonFX(Constants.turretMotorCANID);
        turretMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    public void moveArm(double turretSpeed){
        turretMotor.set(turretSpeed);
    
    }
}
