package LoggingSystem;

public class LoggerDemo {
    public static void main(String[] args) {
        System.out.println("=====> Logging System <=====");

        LogProcessor logProcessor = getChainOfLoggers();

        System.out.println("Logging Messages:");

        System.out.println("=====> Logging DEBUG message <=====");
        logProcessor.logMessage(LogProcessor.DEBUG, "This is a debug message");

        System.out.println("=====> Logging INFO message <=====");
        logProcessor.logMessage(LogProcessor.INFO, "This is a info message");

        System.out.println("=====> Logging ERROR message <=====");
        logProcessor.logMessage(LogProcessor.ERROR, "This is a error message");

        System.out.println("=====> Logging FATAL message <=====");
        logProcessor.logMessage(LogProcessor.FATAL, "This is a fatal message");
    }

    private static LogProcessor getChainOfLoggers() {
        LogProcessor fatalLogger = new FatalLogProcessor(LogProcessor.FATAL);
        LogProcessor errorLogger = new ErrorLogProcessor(LogProcessor.ERROR);
        LogProcessor infoLogger = new InfoLogProcessor(LogProcessor.INFO);
        LogProcessor debugLogger = new DebugLogProcessor(LogProcessor.DEBUG);

        // Dynamic Chaining:L DEBUG -> INFO -> ERROR -> FATAL
        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fatalLogger);

        return debugLogger;
    }
}