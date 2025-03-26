public class StringConcatenatePerformance {
    public static void main(String[] args) {
        int N = 10000; // Number of operations

        //String (Immutable)
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
        long endTime = System.nanoTime();
        System.out.println("String Time: " + (endTime - startTime) / 1_000_000 + " ms"); //1 ms = 1,000,000 nanoseconds

        //StringBuilder (Fast, mutable)
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");

        //StringBuffer (Thread-safe, slightly slower)
        startTime = System.nanoTime();
        StringBuffer strb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            strb.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}

/*
String Time: 37 ms
StringBuilder Time: 1 ms
StringBuffer Time: 3 ms
 */
