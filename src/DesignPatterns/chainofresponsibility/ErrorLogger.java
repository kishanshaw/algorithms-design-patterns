package DesignPatterns.chainofresponsibility;

import java.util.Date;

public class ErrorLogger extends Logger {
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logLevel, String message) {
        if (logLevel == Logger.ERROR) {
            System.out.println(new Date() + " ERROR: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
