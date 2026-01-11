package frc.robot.subsystems;

import com.thethriftybot.devices.ThriftyNova;
import com.thethriftybot.devices.ThriftyNova.MotorType;
import com.thethriftybot.devices.ThriftyNova.ThriftyNovaConfig;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsystem extends SubsystemBase{
    private final ThriftyNova motor = new ThriftyNova(1);//, MotorType.NEO);
    private final XboxController xbox;

    public Subsystem(XboxController xbox){
        motor.setMotorType(MotorType.NEO);
        this.xbox = xbox;
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

    @Override
    public void periodic(){
        motor.set(xbox.getLeftX());
        SmartDashboard.putNumber("Xbox left x", xbox.getLeftX());
        //System.out.println("periodic is running");
    }
}
