package binarySearch;

public class SingleElement {
    // . Single Element in a Sorted Array
    // https://leetcode.com/problems/single-element-in-a-sorted-array/
    private static int findNonDuplicateElement(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }
            if (arr[start] == arr[start + 1]) {
                start += 2;
            } else {
                return arr[start];
            }
            if (arr[end] == arr[end - 1]) {
                end -= 2;
            } else {
                return arr[end];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 4, 4, 5, 5 };
        System.out.println(findNonDuplicateElement(arr));
    }
}