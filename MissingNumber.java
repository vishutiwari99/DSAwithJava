import java.util.stream.IntStream;

public class MissingNumber {
    public static void main(String[] args) {
        int[] a = IntStream.range(1, 11).toArray();
        for (int i : a) {
            System.out.println(i);
        }
    }
}