// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.overture.lib.motorcontrollers.OverTalonFX;

import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class motors extends SubsystemBase {
private OverTalonFX motor;
protected final VoltageOut voltageR = new VoltageOut(0.0);
  public motors() {
   motor = new OverTalonFX(constants.motorconfig(), constants.motorCanId, constants.rio);
  }
public Command moveMotor(Voltage volts){
  return runOnce(() -> {
    motor.setControl(voltageR.withOutput(volts));
  });
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
