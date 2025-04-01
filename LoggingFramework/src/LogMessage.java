public class LogMessage {
    private final LogLevel logLevel;
    private final long timestamp;
    private final String message;

    public LogMessage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[logLevel=" + logLevel +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ']';
    }
}
