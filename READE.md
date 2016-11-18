## Overview

The log framework is used for message logging, and designed for Android platform in special, there were many famous logging library, such as [log4j](http://logging.apache.org/log4j), [slf4j](http://www.slf4j.org), [logback](http://logback.qos.ch), etc. All of those were designed for Java, but Android is not Java, the cost of time during application startup is a very import evaluation indicator for an application. Reducing the I/O consuming time during application startup is helpful for improving the performance, so, that's why it's been created.

This log framework is an interface for logging, it doesn't contains implementations in default, it must be combined with only one of logger implementations in following list or other implementation.

- [Nop Logger](http://nop.log.sdklite.com) - A silent logger implementation
- [Platform Logger](http://platform.log.sdklite.com) - Platform dependent logger which provided by log framework
- [File Logger](http://file.log.sdklite.com) - Output log message into file

## Getting Started

```java
Logger logger = LoggerFactory.getLogger("Anonymous");

logger.info("Application startup at {0,time} on {0,date}", new Date());

try {
    ...
} catch (Throwable t) {
    logger.error("Oops! error occurred: {0}", t);
}
```

## Customization

The interface and implementaion of logger are bound by the [LoggerBinder](./src/main/java/com/sdklite/log/bind/LoggerBinder.java) stub class, so, any logger implementation must implements the stub methods in [LoggerBinder](./src/main/java/com/sdklite/log/bind/LoggerBinder.java) class, for example:

### LoggerBinder

```java
package com.sdklite.log.bind;

import com.sdklite.log.Level;
import com.sdklite.log.Logger;

public class LoggerBinder {

    public static final LoggerBinder getInstance() {
        return Internal.BINDER;
    }

    private LoggerBinder() {
    }

    public Logger getLogger(final String name) {
        return new ConsoleLogger(name);
    }

    public Level getDefaultLevel() {
        return Level.INFO;
    }

    private staitc final class Internal {
        private static final LoggerBinder BINDER = new LoggerBinder();
    }
}
```

### ConsoleLogger

```java
public class ConsoleLogger extends AbstractLogger {

    private final String name;

    public ConsoleLogger(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Logger println(final Level level, final String msg, final Object... args) {
        if (level.intValue() < Level.ERROR.intValue()) {
            System.out.println(format(msg, args));
        } else if (level.intValue() < Level.OFF.intValue()) {
            System.err.println(format(msg, args));
        }

        return this;
    }

}
```

## Download

### GitHub

The distribution binary is available on [GitHub](https://github.com/sdklite/log/releases).

### Maven

```xml
<dependency>
  <groupId>com.sdklite</groupId>
  <groupId>log</groupId>
  <version>0.0.1</version>
</dependency>
```

### Gradle

```gradle
compile 'com.sdklite:log:0.0.1'
```

## Documentation

Please see [http://log.sdklite.com](http://log.sdklite.com).