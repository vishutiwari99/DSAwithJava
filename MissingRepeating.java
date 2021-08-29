import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingRepeating {

    public static void findTwoElement(int[] arr) {
        int[] res = new int[2];
        Map<Integer, Boolean> hm = new HashMap<>();
        for (int i : arr) {
            if (hm.containsKey(i)) {
                res[0] = i;
            } else {
                hm.put(i, true);
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            if (!hm.containsKey(i)) {
                res[1] = i;
            }
        }

        System.out.println("Repeating element is : " + res[0]);
        System.out.println("Missing element is : " + res[1]);
    }

    public static void findTwoElement1(int[] arr) {
        int temp[] = new int[arr.length];
        Arrays.fill(temp, 0);
        for (int i = 0; i < arr.length; i++) {
            if (temp[arr[i] - 1] == 0) {
                temp[arr[i] - 1] = 1;
            } else if (temp[arr[i] - 1] == 1) {
                System.out.println("Repeating element " + arr[i]);
                break;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                System.out.println("Missing element is " + (i + 1));
                break;
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 5, 7, 6 };
        // findTwoElement(arr);
        findTwoElement1(arr);

    }
}