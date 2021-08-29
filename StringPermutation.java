import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static int permutation(int p) {
        int temp = 1;
        while (p > 1) {
            temp = p * temp;
            p--;
        }
        return temp;
    }

    public static List<String> find_permutation(String S) {
        List<String> ls = new ArrayList<>();
        int len = S.length();
        int p = permutation(len);
        for (int i = 0; i < p; i++) {
            StringBuilder sb = new StringBuilder(S);
            StringBuilder ns = new StringBuilder();
            int temp = i;
            for (int div = len; div >= 1; div--) {
                int q = temp / div;
                int r = temp % div;
                char val = sb.charAt(r);
                ns.append(val);
                sb.deleteCharAt(r);
                temp = q;
            }
            ls.add(ns.toString());
        }
        System.out.println(ls);
        return ls;
    }

    public static void printStringPermutation(String str) {
        int n = str.length();
        int f = permutation(n);
        for (int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for (int div = n; div >= 1; div--) {
                int q = temp / div;
                int r = temp % div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        String str = "abc";
        printStringPermutation(str);
        // find_permutation(str);

    }
}