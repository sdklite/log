package com.sdklite.log;

import org.junit.Test;

public class TestLogger {

    @Test
    public void test_abstract_logger_format() {
        final AbstractLogger logger = new AbstractLogger() {
            @Override
            public Logger println(Level level, String msg, Object... args) {
                return this;
            }

            @Override
            public String getName() {
                return "test";
            }
        };

        System.out.println(logger.format("Exception occurred: {0}", new RuntimeException()));
    }

    @Test
    public void test_standard_logger_format() {
        final StandardLogger logger = new StandardLogger();
        System.out.println(logger.format(Level.DEBUG, "Oops!: {0}", new RuntimeException()));
    }
}
