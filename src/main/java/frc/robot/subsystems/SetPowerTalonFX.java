package frc.robot.subsystems;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utility.motor.SafeTalonFX;
import frc.robot.utility.motor.SafeMotor.IdleMode;
import frc.robot.utility.shuffleboard.ShuffleboardValue;

public class SetPowerTalonFX extends SubsystemBase {
    
    private final ShuffleboardValue<Double> voltage = 
        ShuffleboardValue.create(0.0, "Voltage", SetPowerTalonFX.class.getSimpleName())
        .build();
    private final SafeTalonFX motor;

    protected final ShuffleboardValue<Double> encoderPositionWriter = 
        ShuffleboardValue.create(0.0, "Set Power Writer", SetPowerTalonFX.class.getSimpleName())
            .withSize(1, 3)
            .build();
    protected final ShuffleboardValue<Boolean> isMovingManually = 
        ShuffleboardValue.create(false, "Moving manually", SetPowerTalonFX.class.getSimpleName())
            .withSize(1, 2)
            .build();

    public SetPowerTalonFX(Boolean isEnabled, int deviceId) {
        motor = new SafeTalonFX(
            deviceId, 
            ShuffleboardValue.create(isEnabled, "Is Enabled", SetPowerTalonFX.class.getSimpleName())
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
