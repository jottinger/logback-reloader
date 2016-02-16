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
