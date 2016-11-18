package com.sdklite.log;

import com.sdklite.log.bind.LoggerBinder;

/**
 * Represents the factory for logger instantializing
 * 
 * @author johnsonlee
 *
 */
public class LoggerFactory {

    /**
     * Obtain a logger with class
     * 
     * @param clazz
     *            The class for logging
     * @return an instance of logger
     */
    public static Logger getLogger(final Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    /**
     * Obtain a logger with name
     * 
     * @return an instance of logger
     */
    public static final Logger getLogger(final String name) {
        final Logger logger = LoggerBinder.getInstance().getLogger(name);
        if (null != logger) {
            return logger;
        }

        return Internal.DEFAULT;
    }

    private static final class Internal {

        private static final Logger DEFAULT;

        static {
            boolean isAndroid = false;

            try {
                isAndroid = null != Class.forName("android.util.Log");
            } catch (final ClassNotFoundException e) {
            }

            DEFAULT = isAndroid ? new LogcatLogger() : new StandardLogger();
        }
    }
}
