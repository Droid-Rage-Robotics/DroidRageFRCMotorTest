package frc.robot.commands.manual;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.DroidRageConstants;
import frc.robot.subsystems.SetPowerTalonFX;
public class ManualTalonFXSetPower extends CommandBase {
    private final SetPowerTalonFX setPowerTalonFX;
    private final Supplier<Double> setPowerMove;
    
    public ManualTalonFXSetPower(Supplier<Double> setPowerMove, SetPowerTalonFX setPowerTalonFX) {
        this.setPowerTalonFX = setPowerTalonFX;
        this.setPowerMove = setPowerMove;
        
        addRequirements(setPowerTalonFX);
    }

    @Override
    public void initialize() { }

    @Override
    public void execute() {
        double move = -setPowerMove.get();
        move = DroidRageConstants.squareInput(move);
        move = DroidRageConstants.applyDeadBand(move);
        setPowerTalonFX.setPowerCommand(move * 0.2);
        setPowerTalonFX.setMovingManually(!(move == 0));
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
