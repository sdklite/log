package com.sdklite.log;

class StandardLogger extends AbstractLogger {

    @Override
    public Logger println(final Level level, final String msg, final Object... args) {
        if (level.value < Level.ERROR.value) {
            System.out.println(format(level, msg, args));
        } else if (level.value < Level.OFF.value) {
            System.err.println(format(level, msg, args));
        }

        return this;
    }

    String format(final Level level, final String msg, final Object... args) {
        return format(new StringBuilder(inferSourceCodeLocation()).append(" ").append(level), msg, args);
    }

    @Override
    public String getName() {
        return "standard";
    }

}
