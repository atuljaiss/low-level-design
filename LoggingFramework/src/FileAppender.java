import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {

    private final String filepath;

    public FileAppender(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void append(LogMessage logMessage) {
        try (FileWriter writer = new FileWriter(filepath, true)) {
            writer.write(logMessage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
