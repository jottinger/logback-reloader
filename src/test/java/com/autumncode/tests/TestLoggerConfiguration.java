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
package com.autumncode.tests;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import com.autumncode.components.LogThing;
import com.autumncode.logger.InMemoryAppender;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@ContextConfiguration("/testContext.xml")
public class TestLoggerConfiguration extends AbstractTestNGSpringContextTests {
    @Autowired
    @Qualifier("fineLogThing")
    LogThing fineLogThing;

    @Autowired
    @Qualifier("coarseLogThing")
    LogThing coarseLogThing;

    @Autowired
    InMemoryAppender appender;

    @Test
    public void testBaseConfiguration() throws JoranException {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);
        configurator.doConfigure(this.getClass().getResourceAsStream("/logback.xml"));
        appender.reset();
        fineLogThing.doSomething();
        assertEquals(appender.getLogMessages().size(), 5);
        appender.reset();
        coarseLogThing.doSomething();
        assertEquals(appender.getLogMessages().size(), 3);
    }

    @Test
    public void testNewConfiguration() throws JoranException {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);
        configurator.doConfigure(this.getClass().getResourceAsStream("/logback-other.xml"));
        appender.reset();
        fineLogThing.doSomething();
        assertEquals(appender.getLogMessages().size(), 5);
        appender.reset();
        coarseLogThing.doSomething();
        assertEquals(appender.getLogMessages().size(), 5);
    }
}
