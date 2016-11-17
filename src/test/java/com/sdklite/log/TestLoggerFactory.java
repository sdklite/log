package com.sdklite.log;

import org.junit.Test;

public class TestLoggerFactory {

    @Test(expected = RuntimeException.class)
    public void test_obtain_logger() {
        final Logger logger = LoggerFactory.getLogger();
        logger.debug("{0} {1}", "Oops!", new RuntimeException());
    }
}
