package binarySearch;

// Find in Mountain Array
// https://leetcode.com/problems/find-in-mountain-array/
public class FindMinIndexMountainArray {
    private static int orderAgnosticBinarySearch(int[] mountainArr, int start, int end, int target) {
        boolean isAscending = mountainArr[start] < mountainArr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr[mid] == target) {
                return mid;
            }
            if (isAscending) {
                if (target < mountainArr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > mountainArr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

        }
        return -1;
    }

    static int findPeakIndex(int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr[mid] > mountainArr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;

    }

    public static int findInMountainArray(int[] mountainArr, int target) {
        int peak = findPeakIndex(mountainArr);
        int min = orderAgnosticBinarySearch(mountainArr, 0, peak, target);
        if (min != -1)
            return min;
        return orderAgnosticBinarySearch(mountainArr, peak + 1, mountainArr.length - 1, target);

    }

    public static void main(String[] args) {
        int[] mountainArr = { 1, 2, 3, 4, 3, 1 };
        int target = 3;
        System.out.println(findInMountainArray(mountainArr, target));
    }
}