package frc.robot.commands.manual;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.DroidRageConstants;
import frc.robot.subsystems.SetPowerVictorSPX;
public class ManualVictorSPXSetPower extends CommandBase {
    private final SetPowerVictorSPX setPowerVictorSPX;
    private final Supplier<Double> setPowerMove;
    
    public ManualVictorSPXSetPower(Supplier<Double> setPowerMove, SetPowerVictorSPX setPowerVictorSPX) {
        this.setPowerVictorSPX = setPowerVictorSPX;
        this.setPowerMove = setPowerMove;
        
        addRequirements(setPowerVictorSPX);
    }

    @Override
    public void initialize() { }

    @Override
    public void execute() {
        double move = -setPowerMove.get();
        move = DroidRageConstants.squareInput(move);
        move = DroidRageConstants.applyDeadBand(move);
        setPowerVictorSPX.setPowerCommand(move * 0.2);
        setPowerVictorSPX.setMovingManually(!(move == 0));
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
