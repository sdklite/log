package com.sdklite.log;

/**
 * Represents the interface for message logging
 * 
 * @author johnsonlee
 *
 */
public interface Logger extends Appendable {

    /**
     * Returns the level
     */
    public Level getLevel();

    /**
     * Prints the specified message
     * 
     * @param level
     *            The level
     * @param msg
     *            The message
     * @param args
     *            The parameters of message
     * @return this logger
     */
    public Logger println(final Level level, final String msg, final Object... args);

    /**
     * Prints the specified message as {@link Level#TRACE} level
     * 
     * @param msg
     *            The message
     * @param args
     *            The parameters of message
     * @return this logger
     */
    public Logger trace(final String msg, final Object... args);

    /**
     * Prints the specified message as {@link Level#DEBUG} level
     * 
     * @param msg
     *            The message
     * @param args
     *            The parameters of message
     * @return this logger
     */
    public Logger debug(final String msg, final Object... args);

    /**
     * Prints the specified message as {@link Level#INFO} level
     * 
     * @param msg
     *            The message
     * @param args
     *            The parameters of message
     * @return this logger
     */
    public Logger info(final String msg, final Object... args);

    /**
     * Prints the specified message as {@link Level#WARN} level
     * 
     * @param msg
     *            The message
     * @param args
     *            The parameters of message
     * @return this logger
     */
    public Logger warn(final String msg, final Object... args);

    /**
     * Prints the specified message as {@link Level#ERROR} level
     * 
     * @param msg
     *            The message
     * @param args
     *            The parameters of message
     * @return this logger
     */
    public Logger error(final String msg, final Object... args);

}
