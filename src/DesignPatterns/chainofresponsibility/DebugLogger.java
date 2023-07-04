package DesignPatterns.chainofresponsibility;

import java.util.Date;

public class DebugLogger extends Logger {
    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logLevel, String message) {
        if (logLevel == Logger.DEBUG) {

            System.out.println(new Date() + " DEBUG: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
