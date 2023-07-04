package DesignPatterns.chainofresponsibility;

public abstract class Logger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int WARN = 3;
    public static final int ERROR = 4;
    private final Logger nextLogger;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(int logLevel, String message) {
        if (nextLogger != null) {
            nextLogger.log(logLevel, message);
        }
    }
}
