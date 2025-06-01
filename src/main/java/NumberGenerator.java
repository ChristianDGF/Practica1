import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NumberGenerator {
    public static void generate(String filename, int count) throws IOException {
        Random rand = new Random();
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < count; i++) {
                int num = 1 + rand.nextInt(10_000);
                writer.write(num + "\n");
            }
        }
    }
}
