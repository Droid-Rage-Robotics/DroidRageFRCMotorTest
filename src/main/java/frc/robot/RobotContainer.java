package frc.robot;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.manual.ManualSparkMaxSetPower;
import frc.robot.commands.manual.ManualTalonFXSetPower;
import frc.robot.commands.manual.ManualVictorSPXSetPower;
import frc.robot.subsystems.SetPowerSparkMax;
import frc.robot.subsystems.SetPowerTalonFX;
import frc.robot.subsystems.SetPowerVictorSPX;
import frc.robot.utility.shuffleboard.ShuffleboardValue;

public class RobotContainer {
    private final CommandXboxController driver =
        new CommandXboxController(DroidRageConstants.Gamepad.DRIVER_CONTROLLER_PORT);
    // private final CommandXboxController operator =
    //     new CommandXboxController(DroidRageConstants.Gamepad.OPERATOR_CONTROLLER_PORT);

    private final SetPowerSparkMax setPowerSparkMax = new SetPowerSparkMax(false,30);
    private final SetPowerTalonFX setPowerTalonFX = new SetPowerTalonFX(false, 31);
    private final SetPowerVictorSPX setPowerVictorSPX = new SetPowerVictorSPX(false, 32);

    private ShuffleboardValue<Double> matchTime = ShuffleboardValue.create(0.0, "Match Time", "Misc")
        .withWidget(BuiltInWidgets.kTextView)
        .build();
    public RobotContainer() {
        
    }

    public void configureTestBindings() {
        DriverStation.silenceJoystickConnectionWarning(true);


        driver.rightTrigger()
          .onTrue(setPowerSparkMax.setPowerCommand(1));
        driver.leftTrigger()
          .onTrue(setPowerSparkMax.setPowerCommand(-1));
        setPowerSparkMax.setDefaultCommand(new ManualSparkMaxSetPower(driver::getRightX, setPowerSparkMax));

        driver.rightTrigger()
          .onTrue(setPowerTalonFX.setPowerCommand(1));
        driver.leftTrigger()
          .onTrue(setPowerTalonFX.setPowerCommand(-1));
          setPowerTalonFX.setDefaultCommand(new ManualTalonFXSetPower(driver::getRightX, setPowerTalonFX));
        
        driver.rightTrigger()
          .onTrue(setPowerVictorSPX.setPowerCommand(1));
        driver.leftTrigger()
          .onTrue(setPowerVictorSPX.setPowerCommand(-1));
          setPowerVictorSPX.setDefaultCommand(new ManualVictorSPXSetPower(driver::getRightX, setPowerVictorSPX));
        
    }
    
}
