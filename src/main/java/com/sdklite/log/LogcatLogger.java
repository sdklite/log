package com.sdklite.log;

import android.util.Log;

class LogcatLogger extends AbstractLogger {

    @Override
    public Logger println(final Level level, final String msg, final Object... args) {
        switch (level) {
        case TRACE: {
            final StackTraceElement caller = inferCaller();
            Log.println(Log.VERBOSE, caller.getFileName() + ":" + caller.getLineNumber(), format(msg, args));
            break;
        }
        case DEBUG:
            Log.println(Log.DEBUG, inferCaller().getClassName(), format(msg, args));
            break;
        case INFO:
            Log.println(Log.INFO, inferCaller().getClassName(), format(msg, args));
            break;
        case WARN:
            Log.println(Log.WARN, inferCaller().getClassName(), format(msg, args));
            break;
        case ERROR:
            Log.println(Log.ERROR, inferCaller().getClassName(), format(msg, args));
            break;
        default:
            break;
        }

        return this;
    }

    @Override
    public String getName() {
        return "logcat";
    }

}
