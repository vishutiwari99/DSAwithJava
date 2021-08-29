import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingFrequencies {

    // O(n^2) approach
    public static void printFrequencies(int[] arr) {
        boolean visited[] = new boolean[arr.length];
        Arrays.fill(visited, false);
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true)
                continue;
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }

    // o(n) hashing approach
    public static void printFrequencies2(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " =>" + entry.getValue() + " times");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 3, 4, 4 };
        // CountingFrequencies.printFrequencies(arr);
        CountingFrequencies.printFrequencies2(arr);

    }
}