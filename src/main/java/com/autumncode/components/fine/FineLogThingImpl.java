package com.autumncode.components.fine;

import com.autumncode.components.LogThing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("fineLogThing")
public class FineLogThingImpl implements LogThing {
    static final Logger log = LoggerFactory.getLogger(FineLogThingImpl.class);

    @Override
    public Logger getLog() {
        return log;
    }
}
