package frc.robot;

public final class DroidRageConstants {
    public static class GamePad {
        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final int OPERATOR_CONTROLLER_PORT = 1;
        public static final double DRIVER_STICK_DEAD_ZONE = 0.05;
        public static final double OPERATOR_STICK_DEAD_ZONE = 0.2;
    }

    public static double LOOP_TYPE_SECONDS = 0.02;

    public static double squareInput(double value) {
        return value * Math.abs(value);
    }

    public static double applyDeadBand(double value) {
        if (Math.abs(value) < DroidRageConstants.GamePad.OPERATOR_STICK_DEAD_ZONE) value = 0;
        return value;
    }

    public static boolean isWithinDeadZone(double stick) {
        return Math.abs(stick) < DroidRageConstants.GamePad.OPERATOR_STICK_DEAD_ZONE;
    }
}
