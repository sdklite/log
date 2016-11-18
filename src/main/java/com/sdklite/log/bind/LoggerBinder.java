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

    /**
     * Returns the biner instance
     */
    public static final LoggerBinder getInstance() {
        throw new RuntimeException("Stub!");
    }

    private LoggerBinder() {
        throw new RuntimeException("Stub!");
    }

    /**
     * Obtain a logger with the specified name
     * 
     * @param name
     *            The name of logger
     * @return an instance of logger
     */
    public Logger getLogger(final String name) {
        throw new RuntimeException("Stub!");
    }

    /**
     * Returns the default log level
     */
    public Level getDefaultLevel() {
        throw new RuntimeException("Stub!");
    }

}
