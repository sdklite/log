package com.sdklite.log;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.MessageFormat;

/**
 * An abstraction of generic logger
 * 
 * @author johnsonlee
 *
 */
public abstract class AbstractLogger implements Logger {

    private static final String CLASS_NAME = AbstractLogger.class.getName();

    private static final StackTraceElement UNKNOWN_STRACE_TRACE = new StackTraceElement("unknown", "unknown", "unknown", -1);

    protected Level level = Build.VERSION.endsWith("-SNAPSHOT") ? Level.TRACE : Level.OFF;

    /**
     * Default constructor
     */
    public AbstractLogger() {
    }

    @Override
    public final Appendable append(final CharSequence csq) throws IOException {
        return this.append(csq, 0, csq.length());
    }

    @Override
    public final Appendable append(final CharSequence csq, final int start, final int end) throws IOException {
        return this.println(getLevel(), String.valueOf(null == csq ? null : csq.subSequence(start, end)));
    }

    @Override
    public final Appendable append(final char c) throws IOException {
        return this.println(getLevel(), new String(new char[] { c }));
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(final Level level) {
        if (null == level) {
            throw new IllegalArgumentException("level is null");
        }

        this.level = level;
    }

    @Override
    public final Logger trace(final String msg, final Object... args) {
        return this.println(Level.TRACE, msg, args);
    }

    @Override
    public final Logger debug(final String msg, final Object... args) {
        return this.println(Level.DEBUG, msg, args);
    }

    @Override
    public final Logger info(final String msg, final Object... args) {
        return this.println(Level.INFO, msg, args);
    }

    @Override
    public final Logger warn(final String msg, final Object... args) {
        return this.println(Level.WARN, msg, args);
    }

    @Override
    public final Logger error(final String msg, final Object... args) {
        return this.println(Level.ERROR, msg, args);
    }

    /**
     * Format the specified pattern with parameters
     * 
     * @param pattern
     *            The format pattern
     * @param args
     *            The parameters of pattern
     * @return a formatted string
     */
    protected String format(final String pattern, final Object...args) {
        return this.format(new StringBuffer(), pattern, args);
    }

    /**
     * Format the specified pattern with parameters
     * 
     * @param prefix
     *            The prefix to add
     * @param pattern
     *            The format pattern
     * @param args
     *            The parameters of pattern
     * @return a formatted string
     */
    protected String format(final CharSequence prefix, final String pattern, final Object...args) {
        final MessageFormat mf = new MessageFormat(pattern);
        final StringBuffer buffer = new StringBuffer(prefix).append(" ");

        for (int i = 0, n = args.length; i < n; i++) {
            if (args[i] instanceof Throwable) {
                mf.setFormat(i, ThrowableFormat.getInstance());
            }
        }

        return mf.format(args, buffer, new FieldPosition(0)).toString();
    }

    /**
     * Infer the source code location of caller
     * 
     * @return a string consists of file name and line number
     */
    protected static CharSequence inferSourceCodeLocation() {
        final StackTraceElement caller = inferCaller();
        return new StringBuilder(caller.getFileName()).append(":").append(caller.getLineNumber());
    }

    /**
     * Infer the invocation location of caller
     * 
     * @return a string consists of class name and method name
     */
    protected static CharSequence inferInvocationLocation() {
        final StackTraceElement caller = inferCaller();
        return new StringBuilder(caller.getClassName()).append("#").append(caller.getMethodName());
    }

    /**
     * Infer the caller from stack trace
     * 
     * @return the last stack trace element which called from outside of logger 
     */
    protected static StackTraceElement inferCaller() {
        final Throwable t = new Throwable();
        final StackTraceElement[] stack = t.getStackTrace();
        for (final StackTraceElement ste : stack) {
            try {
                if (ste.getClassName().equals(CLASS_NAME) || Logger.class.isAssignableFrom(Class.forName(ste.getClassName()))) {
                    continue;
                }
            } catch (final ClassNotFoundException e) {
            }

            return ste;
        }

        return UNKNOWN_STRACE_TRACE;
    }
}
