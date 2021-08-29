package binarySearch;

public class CelingFloor {
    // return the index of greatest number which is smaller than or equal to target
    private static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return end;
    }

    // return the index of smallest number which is greater than equal to target
    private static int celling(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 6 };
        int target = 7;
        System.out.println("Ceiling of a number " + target + " is " + arr[celling(arr, target)]);
        System.out.println("floor of a number " + target + " is " + arr[floor(arr, target)]);
    }
}