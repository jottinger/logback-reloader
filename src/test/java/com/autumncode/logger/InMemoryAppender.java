package com.autumncode.logger;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryAppender extends AppenderBase {
    static List<String> logMessages = new ArrayList<>();

    public synchronized void reset() {
        logMessages.clear();
    }

    public List<String> getLogMessages() {
        return logMessages;
    }

    @Override
    protected void append(Object o) {
        if (o instanceof LoggingEvent) {
            LoggingEvent le = (LoggingEvent) o;
            String message=le.getLoggerName() + ":" + le.getFormattedMessage();
            logMessages.add(message);
            System.out.println(message);
        }
    }
}
