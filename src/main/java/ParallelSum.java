import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParallelSum {
    public static long sum(String filename, int numThreads) throws IOException, InterruptedException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        int size = lines.size();
        long[] results = new long[numThreads];
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                int start = index * size / numThreads;
                int end = (index + 1) * size / numThreads;
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += Long.parseLong(lines.get(j));
                }
                results[index] = sum;
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        long total = 0;
        for (long val : results) total += val;
        return total;
    }
}
