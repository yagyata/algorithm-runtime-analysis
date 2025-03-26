import java.util.Arrays;
import java.util.Random;

public class SortingTimeAnalysis {

    // Bubble Sort: O(N²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort: O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort: O(N log N)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Different dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] dataset1 = new int[size];
            int[] dataset2 = new int[size];
            int[] dataset3 = new int[size];

            // Generate random numbers
            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size * 10);
                dataset1[i] = dataset2[i] = dataset3[i] = num;
            }

            // Measure Bubble Sort Time (Only for small datasets)
            if (size <= 10000) {
                long start = System.nanoTime();
                bubbleSort(dataset1);
                long bubbleTime = System.nanoTime() - start;
                System.out.println("Bubble Sort Time for " + size + ": " + bubbleTime / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort Skipped for " + size);
            }

            // Measure Merge Sort Time
            long start = System.nanoTime();
            mergeSort(dataset2, 0, dataset2.length - 1);
            long mergeTime = System.nanoTime() - start;
            System.out.println("Merge Sort Time for " + size + ": " + mergeTime / 1_000_000.0 + " ms");

            // Measure Quick Sort Time
            start = System.nanoTime();
            quickSort(dataset3, 0, dataset3.length - 1);
            long quickTime = System.nanoTime() - start;
            System.out.println("Quick Sort Time for " + size + ": " + quickTime / 1_000_000.0 + " ms");

            System.out.println();

        }
    }
}

/*
Bubble Sort Time for 1000: 8.7987 ms
Merge Sort Time for 1000: 1.6235 ms
Quick Sort Time for 1000: 0.8345 ms

Bubble Sort Time for 10000: 243.8075 ms
Merge Sort Time for 10000: 4.1067 ms
Quick Sort Time for 10000: 2.001 ms

Bubble Sort Skipped for 1000000
Merge Sort Time for 1000000: 424.7966 ms
Quick Sort Time for 1000000: 223.9466 ms
 */
