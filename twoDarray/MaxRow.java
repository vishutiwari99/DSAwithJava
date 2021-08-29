package twoDarray;

public class MaxRow {

    static int rowWithMax1s(int arr[][], int n, int m) {
        int r = 0; // keeps track of row; starts at first row
        int c = m - 1; // keeps track of column; starts at last column
        int max_row_index = -1; // keeps track of result row index

        // starting from top right corner
        // go left if you encounter 1
        // do down if you encounter 0
        while (r < n && c >= 0) {
            if (arr[r][c] == 1) {
                max_row_index = r;
                c--;
            } else
                r++;
        }
        return max_row_index;
    }

    static int maxRow(int[][] arr) {
        int R = arr.length;
        int max_row_index = 0;
        int max = -1;
        int i, index;
        for (i = 0; i < R; i++) {
            index = getIndex(arr[i], 0, ((arr[i].length) - 1));
            int C = arr[i].length;
            if (index != -1 && C - index > max) {
                max = arr[i].length - index;
                max_row_index = i;
            }
        }
        if (max < 1) {
            return -1;
        } else {
            return max_row_index;
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1) {
                return mid;
            } else if (arr[mid] == 0)
                return getIndex(arr, (mid + 1), high);
            else
                return getIndex(arr, low, (mid - 1));
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 0, 0, 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 1, 1, 1, 1, 1, 1, } };
        // System.out.println(maxRow(arr));
        System.out.println(rowWithMax1s(arr, 2, 9));
    }
}