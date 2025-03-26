import java.util.Arrays;
import java.util.Random;

public class SearchTarget {

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found
            }
        }
        return -1;
    }

    // Binary Search: O(log N)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();

        for (int size : sizes) {
            int[] dataset = new int[size];

            // Fill dataset with random numbers
            for (int i = 0; i < size; i++) {
                dataset[i] = random.nextInt(size * 10);
            }

            int target = dataset[random.nextInt(size)]; // Pick a random target

            // Measure Linear Search Time
            long start = System.nanoTime();
            linearSearch(dataset, target);
            long linearTime = System.nanoTime() - start;

            // Sort dataset for Binary Search
            Arrays.sort(dataset);

            // Measure Binary Search Time
            start = System.nanoTime();
            binarySearch(dataset, target);
            long binaryTime = System.nanoTime() - start;

            // Print Results
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
            System.out.println();
        }
    }
}
