package DesignPatterns.chainofresponsibility;

import java.util.Date;

public class InfoLogger extends Logger {
    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logLevel, String message) {
        if (logLevel == Logger.INFO) {
            System.out.println(new Date() + " INFO: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
