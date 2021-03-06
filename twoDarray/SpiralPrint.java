package twoDarray;

public class SpiralPrint {
    static void printSpiral(int[][] arr) {
        int top = 0, bottom = arr.length - 1, left = 0, right = arr.length - 1;
        int direction = 0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = top; i < right; i++) {
                    System.out.print(arr[top][i] + " ");
                }
                top++;
            } else if (direction == 1) {
                for (int i = right; i <= bottom; i++) {
                    System.out.println(arr[i][right] + " ");
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= bottom; i--) {
                    System.out.println(arr[bottom][i] + " ");
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    System.out.println(arr[i][left] + " ");
                }
                left++;
                direction = (direction + 1) % 4;
            }
        }

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };

        printSpiral(arr);

    }
}