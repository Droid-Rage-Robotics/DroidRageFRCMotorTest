package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utility.motor.SafeCanSparkMax;
import frc.robot.utility.motor.SafeMotor.IdleMode;
import frc.robot.utility.shuffleboard.ShuffleboardValue;

public class SetPowerSparkMax extends SubsystemBase {
    
    private final ShuffleboardValue<Double> voltage = 
        ShuffleboardValue.create(0.0, "Voltage", SetPowerSparkMax.class.getSimpleName())
        .build();
    private final SafeCanSparkMax motor;

    protected final ShuffleboardValue<Double> encoderPositionWriter = 
        ShuffleboardValue.create(0.0, "Set Power Writer", SetPowerSparkMax.class.getSimpleName())
            .withSize(1, 3)
            .build();
    protected final ShuffleboardValue<Boolean> isMovingManually = 
        ShuffleboardValue.create(false, "Moving manually", SetPowerSparkMax.class.getSimpleName())
            .withSize(1, 2)
            .build();

    public SetPowerSparkMax(Boolean isEnabled, int deviceId) {
        motor = new SafeCanSparkMax(
            deviceId, 
            MotorType.kBrushless,
            ShuffleboardValue.create(isEnabled, "Is Enabled", SetPowerSparkMax.class.getSimpleName())
                .withWidget(BuiltInWidgets.kToggleSwitch)
                .build(),
            voltage
        );

        motor.setIdleMode(IdleMode.Brake);
        motor.setInverted(false);
    }

    private void setPower(double power) {
        motor.setPower(power);
    }

    public CommandBase setPowerCommand(double power) {
        return runOnce(()->{
            setPower(power);

        });
        
    }

    public ShuffleboardValue<Boolean> getIsMovingManually() {
        return isMovingManually;
    }

    public void setMovingManually(boolean value) {
        getIsMovingManually().set(value);
    }
}
