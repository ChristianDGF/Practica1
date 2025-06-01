import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SequentialSum {
    public static long sum(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .mapToLong(Long::parseLong)
                .sum();
    }
}
