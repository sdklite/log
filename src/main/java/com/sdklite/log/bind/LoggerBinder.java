package com.sdklite.log.bind;

import com.sdklite.log.Level;
import com.sdklite.log.Logger;

/**
 * A stub class for logger implementation binding, the logger implementation
 * must implements the stub methods.
 * 
 * @author johnsonlee
 *
 */
public class LoggerBinder {

    public static final LoggerBinder getInstance() {
        throw new RuntimeException("Stub!");
    }

    public Logger getLogger(final String name) {
        throw new RuntimeException("Stub!");
    }

    public Level getDefaultLevel() {
        throw new RuntimeException("Stub!");
    }

}
