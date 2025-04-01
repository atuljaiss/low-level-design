# Logging Framework

## Problem Statement
A logging framework that provides multiple log levels, supports different output destinations, and ensures thread safety while handling concurrent logging from multiple threads.

### Requirements
- Support for multiple **log levels**: DEBUG, INFO, WARNING, ERROR, and FATAL.
- Logs messages with **timestamp, log level, and message content**.
- Allows logging to **console, file, and database**.
- Provides a **configuration mechanism** to set log levels and output destinations.
- Ensures **thread safety** for concurrent logging.
- Designed to be **extensible** for adding new log levels and output destinations.

## System Requirements
- **Java 8+**

## UML Diagram

![image](https://drive.google.com/file/d/1CqDCdyVXTps1yXQktU7YlRFvmY7pRAL7/view?usp=sharing)


## Class Design

### 1. LogLevel (Enum)
Defines the supported log levels:
```java
public enum LogLevel {
    DEBUG, INFO, WARNING, ERROR, FATAL;
}
```

### 2. LogMessage
Encapsulates log details like timestamp, level, and message.
```java
public class LogMessage {
    private final LocalDateTime timestamp;
    private final LogLevel level;
    private final String message;
    
    public LogMessage(LogLevel level, String message) {
        this.timestamp = LocalDateTime.now();
        this.level = level;
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "[" + timestamp + "] [" + level + "] " + message;
    }
}
```

### 3. LogAppender (Interface)
Defines how log messages are stored or displayed.
```java
public interface LogAppender {
    void append(LogMessage message);
}
```

### 4. ConsoleAppender
Logs messages to the console.
```java
public class ConsoleAppender implements LogAppender {
    @Override
    public synchronized void append(LogMessage message) {
        System.out.println(message);
    }
}
```

### 5. FileAppender
Logs messages to a file.
```java
public class FileAppender implements LogAppender {
    private final String filePath;
    
    public FileAppender(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public synchronized void append(LogMessage message) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 6. LoggerConfig
Manages log levels and output destinations.
```java
public class LoggerConfig {
    private LogLevel logLevel;
    private List<LogAppender> appenders;
    
    public LoggerConfig(LogLevel logLevel, List<LogAppender> appenders) {
        this.logLevel = logLevel;
        this.appenders = appenders;
    }
    
    public LogLevel getLogLevel() {
        return logLevel;
    }
    
    public List<LogAppender> getAppenders() {
        return appenders;
    }
}
```

### 7. Logger (Singleton)
Manages logging operations.
```java
public class Logger {
    private static Logger instance;
    private LoggerConfig config;
    
    private Logger() {}
    
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public synchronized void setConfig(LoggerConfig config) {
        this.config = config;
    }
    
    public synchronized void log(LogLevel level, String message) {
        if (level.ordinal() >= config.getLogLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(level, message);
            for (LogAppender appender : config.getAppenders()) {
                appender.append(logMessage);
            }
        }
    }
}
```

## Approach
- **Thread-Safety**: All logging methods are synchronized to ensure safe access in multi-threaded environments.
- **Extensibility**: New appenders (e.g., cloud logging, network logging) can be added by implementing `LogAppender`.
- **Configuration Flexibility**: Users can configure the log level and output destination dynamically.
- **Performance Optimization**: Logging can be improved using asynchronous mechanisms in future enhancements.

## Usage Example
```java
public class LoggingExample {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        LoggerConfig config = new LoggerConfig(LogLevel.INFO,
                Arrays.asList(new ConsoleAppender(), new FileAppender("logs.txt")));
        logger.setConfig(config);
        
        logger.log(LogLevel.DEBUG, "This is a debug message");
        logger.log(LogLevel.ERROR, "This is an error message");
    }
}
```

