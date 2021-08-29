import java.util.ArrayList;
import java.util.stream.IntStream;

public class RemovePrimeNumbers {

    public static boolean isPrimeNumber(int number) {
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);

    }

    public static boolean isPrime2(int number) {
        for (int div = 2; div * div <= number; div++) {
            if (number % div == 0) {
                return false;
            }
        }
        return true;

    }

    public static void solution(ArrayList<Integer> al) {
        for (int i = al.size() - 1; i >= 0; i--) {
            int val = al.get(i);
            if (isPrime(val)) {
                al.remove(i);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(12);
        al.add(13);
        al.add(15);
        RemovePrimeNumbers.solution(al);
        System.out.println(al);
    }
}