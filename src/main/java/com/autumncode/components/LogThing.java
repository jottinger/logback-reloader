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
