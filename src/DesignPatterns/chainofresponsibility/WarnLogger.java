package DesignPatterns.chainofresponsibility;

import java.util.Date;

public class WarnLogger extends Logger {
    public WarnLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logLevel, String message) {
        if (logLevel == Logger.WARN) {
            System.out.println(new Date() + " WARN: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
