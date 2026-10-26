// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Volts;

import com.overture.lib.gamepads.OverXboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.constants;
import frc.robot.subsystems.motors;

public class RobotContainer {
  private final OverXboxController driver = new OverXboxController(0, 0, 0);
  private final motors  motors = new motors();
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driver.a().onTrue(motors.moveMotor(constants.lowVel));
    driver.b().onTrue(motors.moveMotor(constants.highVel));
    driver.x().onTrue(motors.moveMotor(constants.stopVel));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
