package com.autumncode.components.coarse;

import com.autumncode.components.LogThing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("coarseLogThing")
public class CoarseLogThingImpl implements LogThing {
    static final Logger log = LoggerFactory.getLogger(CoarseLogThingImpl.class);

    @Override
    public Logger getLog() {
        return log;
    }

}
