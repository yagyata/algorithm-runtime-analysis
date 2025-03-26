import java.util.*;

public class CompareDataStructure {
    public static void main(String[] args) {
        int n = 1_000_000;
        Random random = new Random();
        int target = random.nextInt(n);

        // Initialize structures
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int num = random.nextInt(n);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Search in Array
        long startTime = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long endTime = System.nanoTime();
        System.out.println("Array Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Search in HashSet
        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Search in TreeSet
        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}

/*
Array Search Time: 6.6673 ms
HashSet Search Time: 0.0065 ms
TreeSet Search Time: 0.0198 ms
 */
