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
     * Obtain a logger
     * 
     * @param tag
     *            The tag of logger
     * @return a logger instance
     */
    public static final Logger getLogger() {
        final Logger logger = LoggerBinder.getInstance().getLogger();
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
