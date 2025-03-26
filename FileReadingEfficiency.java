import java.io.*;

public class FileReadingEfficiency {
    public static void main(String[] args) {
        String filePath = "README.md";

        System.out.println("FileReader Time: " + measureFileReader(filePath) + " ms");
        System.out.println("InputStreamReader Time: " + measureInputStreamReader(filePath) + " ms");
    }

    public static long measureFileReader(String filePath) {
        long startTime = System.nanoTime();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {} // Reads character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }

    public static long measureInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}
