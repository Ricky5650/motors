
package frc.robot.subsystems;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.AngularAccelerationUnit;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Velocity;
import edu.wpi.first.units.measure.Voltage;
import static edu.wpi.first.units.Units.*;

import javax.xml.stream.events.StartDocument;

/** Add your docs here. */
public class constants {
public static int motorCanId  = 23;
 public static Voltage lowVel = Volts.of(5);
  public static Voltage highVel = Volts.of(10);
  public static Voltage stopVel = Volts.of(0);
public static final CANBus rio = new CANBus("rio");


    public static TalonFXConfiguration motorconfig(){
        return new TalonFXConfiguration()
        .withCurrentLimits(
            new CurrentLimitsConfigs()
                  .withStatorCurrentLimitEnable(true)
                  .withStatorCurrentLimit(60)
                  .withSupplyCurrentLimitEnable(true)
                  .withSupplyCurrentLimit(20))
        .withVoltage(
            new VoltageConfigs()
                .withPeakForwardVoltage(12)
                .withPeakReverseVoltage(-12))
        .withMotorOutput(
            new MotorOutputConfigs()
                .withInverted(InvertedValue.Clockwise_Positive)
                .withNeutralMode(NeutralModeValue.Coast))
        
        .withFeedback(
                new FeedbackConfigs()
                    .withSensorToMechanismRatio(1)
                );
            
      
      
    }

}
