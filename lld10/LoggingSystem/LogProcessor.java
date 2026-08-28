package LoggingSystem;

public abstract class LogProcessor {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;
    public static final int FATAL = 4;
    int level;
    LogProcessor nextLogProcessor;

    public void setNextLogger(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void logMessage(int level, String message) {
        if (this.level == level) {
            write(message);
            return;
        }

        if (this.nextLogProcessor != null) {
            this.nextLogProcessor.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}