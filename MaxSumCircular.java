public class MaxSumCircular {

    public static int maxSumArray(int[] arr) {
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

    public static int minSumArray(int[] arr) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < min) {
                min = sum;
            }
            if (sum > 0) {
                sum = 0;
            }
        }
        return min;
    }

    public static int maxSumCircular(int[] arr) {

        // checking that all the elements in
        // the array is negative or not.?
        int x = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                x = 1;
                break;
            }
            ans = Math.max(arr[i], ans);
        }
        if (x == 0)
            return ans;
        int ans1 = maxSumArray(arr);
        int total = 0;

        for (int i : arr) {
            total = total + i;
        }
        int ans2 = total - minSumArray(arr);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        // int[] arr = { 10, -3, -4, 7, 6, 5, -4, -1 };
        int[] arr = { 1, 2, -2, -3, 4, 5 };

        // int res = minSumArray(arr);
        int res = maxSumCircular(arr);
        System.out.println(res);
    }
}