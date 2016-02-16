package com.autumncode.components;

import org.slf4j.Logger;

public interface LogThing {
    Logger getLog();
    default void doSomething() {
        getLog().trace("trace message");
        getLog().debug("debug message");
        getLog().warn("warn message");
        getLog().info("info message");
        getLog().error("error message");
    }
}
