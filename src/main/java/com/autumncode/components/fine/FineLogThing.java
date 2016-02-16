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

package com.autumncode.components.fine;

import com.autumncode.components.LogThing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component("fineLogThing")
public class FineLogThing implements LogThing {
    private static final Logger log = LoggerFactory.getLogger(FineLogThing.class);

    @Override
    public Logger getLog() {
        return log;
    }
}
