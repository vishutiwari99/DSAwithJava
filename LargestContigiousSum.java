public class LargestContigiousSum {

    public static int findLargestContigiousSum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(final String[] args) {
        int[] arr1 = { 1, -2, -3, 4, 5 };
        // int[] arr = { 74, -72, 94, -53, -59, -3, -66, 36, -13, 22, 73, 15, -52, 75 };
        int value = findLargestContigiousSum(arr1);
        System.out.println(value);
    }
}