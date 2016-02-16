/*
 *    Copyright 2016, Joseph B. Ottinger
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */
package com.autumncode.logger;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InMemoryAppender extends AppenderBase {
    private static final List<String> logMessages = new CopyOnWriteArrayList<>();

    public void reset() {

        synchronized (logMessages) {
            logMessages.clear();
        }
    }

    public List<String> getLogMessages() {
        synchronized (logMessages) {
            return new ArrayList<>(logMessages);
        }
    }

    @Override
    protected void append(Object o) {
        if (o instanceof LoggingEvent) {
            LoggingEvent le = (LoggingEvent) o;
            String message = le.getLoggerName() + ":" + le.getFormattedMessage();
            logMessages.add(message);
            System.out.println(message);
        }
    }
}
