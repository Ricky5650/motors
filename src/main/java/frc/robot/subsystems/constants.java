
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
            /*usamos esta configuracion para definir los limites de la corriente de nuestro motor 
            esto nos ayuda a que la bateria dure mas, que los breakers no se boten o que el motor no se proteja por sobrecalentamiento*/
            new CurrentLimitsConfigs()
                  .withStatorCurrentLimitEnable(true)
                  .withStatorCurrentLimit(60)  /* aqui limitamos la corriente que sale del motor y como esto esta  directamente relazionado con el torque 
                  lo que significa que tambien controlamos el torque, esto nos ayuda a proejer mecanismos*/

                  .withSupplyCurrentLimitEnable(true)
                  .withSupplyCurrentLimit(20))/*la energia que hagarra del motor limitar esto nos ayuda a no drenar tanta pila */

        .withVoltage(
            new VoltageConfigs()
            /* esta configuracion nos ayuda a limitar el voltage de nuestro motor*/
                .withPeakForwardVoltage(12) //Maximo
                .withPeakReverseVoltage(-12)) //minimo
        .withMotorOutput(
            /*eta configuracion nos ayuda a definir el comporatmiento del motor */
            new MotorOutputConfigs()
                .withInverted(InvertedValue.Clockwise_Positive) /*aqui definimos si queremos que el motor este invertido */
                .withNeutralMode(NeutralModeValue.Coast)) /*aqui definimos si queremos que  el motor se mueva solo o no*/
        
        .withFeedback(
            //configuramos el feedback que resive el motor, en este caso lo usamos para definir los ratios de los
                new FeedbackConfigs()
                    .withSensorToMechanismRatio(1)
                );
            
      
      
    }

}
