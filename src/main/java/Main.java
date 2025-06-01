import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        String filename = "numbers.txt";
        int count = 1_000_000;

        NumberGenerator.generate(filename, count);

        long start = System.nanoTime();
        long sumSequential = SequentialSum.sum(filename);
        long end = System.nanoTime();
        double timeSeq = (end - start) / 1e9;
        System.out.printf("Resultado Secuencial: %d\nTiempo: %.4f s\n\n", sumSequential, timeSeq);

        int[] threads = {2, 4, 8, 16, 32};

        for (int t : threads) {
            System.out.printf("== %d Hilos ==\n", t);

            start = System.nanoTime();
            long sumParallel = ParallelSum.sum(filename, t);
            end = System.nanoTime();
            double timePar = (end - start) / 1e9;

            double speedup = timeSeq / timePar;
            double efficiency = speedup / t;

            System.out.printf("Resultado: %d\n", sumParallel);
            System.out.printf("Tiempo: %.4f s | Speedup: %.2f | Eficiencia: %.2f\n\n", timePar, speedup, efficiency);
        }
    }
}
