package binarySearch;

import java.util.Arrays;

public class FirstLastPosition {
    // Find First and Last Position of Element in Sorted Array
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    static int[] searchRange(int nums[], int target) {
        int start = 0;
        int lo = -1, hi = -1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + (end - start) / 2);
            if (nums[mid] == target) {
                lo = mid;
                hi = mid;
                while (lo >= 0 && nums[lo] == target) {
                    lo--;
                }
                lo++;
                while (hi < nums.length && nums[hi] == target) {
                    hi++;
                }
                hi--;
                break;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[] { lo, hi };
    }

    private static int searchIndex(int nums[], int target, boolean firstIndexOfElement) {
        int res = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                res = mid;
                if (firstIndexOfElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return res;
    }

    static int[] searchRange2(int nums[], int target) {
        int[] ans = { -1, -1 };
        ans[0] = searchIndex(nums, target, true);
        ans[1] = searchIndex(nums, target, false);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 7, 10 };
        int target = 7;
        // System.out.println(Arrays.toString(searchRange(arr, target)));
        System.out.println(Arrays.toString(searchRange2(arr, target)));
    }
}