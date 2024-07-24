package gym.backend.utils;

public class TimeUtils {

    public static String convertMsToTime(long executionTimeMs) {
        if (executionTimeMs < 1000) {
            return executionTimeMs + " ms";
        } else if (executionTimeMs < 60000) {
            return executionTimeMs / 1000.0 + " seconds";
        } else {
            long minutes = executionTimeMs / 1000 / 60;
            long seconds = (executionTimeMs / 1000) % 60;
            return minutes + " minutes " + seconds + " seconds";
        }
    }

}
