package frc.robot.subsystems;

import com.thethriftybot.devices.ThriftyNova;
import com.thethriftybot.devices.ThriftyNova.MotorType;
import com.thethriftybot.devices.ThriftyNova.ThriftyNovaConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem extends SubsystemBase{
    private final ThriftyNova motor = new ThriftyNova(1);

    public Subsystem(){
        motor.setMotorType(MotorType.NEO);
    }

    public Command run(double speed){
        return runEnd(()->{
           // motor.setBrakeMode(false);
            motor.set(speed);
        }, ()->{
            motor.set(0);
            //motor.setBrakeMode(true);
        });
    }
}
