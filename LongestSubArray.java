import java.util.Arrays;

public class LongestSubArray {
    public static int[] findLongestSubArray(int[] arr) {
        int max = 1;
        int len = 1;
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                if (max < len) {
                    max = len;
                    maxIndex = i - max;
                    len = 1;
                }
            }
        }
        if (max < len) {
            max = len;
            maxIndex = arr.length - max;
        }
        int[] res = new int[max];
        for (int j = 0, i = maxIndex; i < max + maxIndex; i++) {
            res[j] = arr[i];
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = { 20, 10, 1, 3, 5, 21, 3, 5 };
        // int[] ans = findLongestSubArray(a.);
        System.out.println(Arrays.toString(findLongestSubArray(a)));
        // System.out.println(Arrays.toString(ans));
    }
}