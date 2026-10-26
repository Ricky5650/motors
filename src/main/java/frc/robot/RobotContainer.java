// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.constants;
import frc.robot.subsystems.motors;

public class RobotContainer {
  CommandXboxController Controler = new CommandXboxController(0);
  private final motors  motors = new motors();
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    Controler.a().onTrue(motors.moveMotor(constants.lowVel));
    Controler.b().onTrue(motors.moveMotor(constants.highVel));
    Controler.x().onTrue(motors.moveMotor(constants.stopVel));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
