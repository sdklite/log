package com.sdklite.log;

/**
 * Represents the log level
 * 
 * @author johnsonlee
 *
 */
public enum Level {

    /**
     * Indicates that the log level is turn off
     */
    OFF(Integer.MAX_VALUE),

    /**
     * Indicates that the log level is {@code TRACE}
     */
    TRACE(1),

    /**
     * Indicates that the log level is {@code DEBUG}
     */
    DEBUG(2),

    /**
     * Indicates that the log level is {@code INFO}
     */
    INFO(3),

    /**
     * Indicates that the log level is {@code WARN}
     */
    WARN(4),

    /**
     * Indicates that the log level is {@code ERROR}
     */
    ERROR(5);

    final int value;

    private Level(final int level) {
        this.value = level;
    }

    /**
     * Returns the int value corresponding to this level
     */
    public int intValue() {
        return this.value;
    }

    /**
     * Returns the enum constant corresponding to the specified level number
     * 
     * @param level
     *            The level number
     * @return the enum constant or null if level number doesn't match
     */
    public static Level valueOf(final int level) {
        if (level == OFF.value) {
            return OFF;
        }

        if (level < TRACE.value || level > ERROR.value) {
            return null;
        }

        return values()[level - 1];
    }
}
