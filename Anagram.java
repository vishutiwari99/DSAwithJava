import java.util.Arrays;

public class Anagram {
    static int NO_OF_CHARS = 256;

    public static Boolean isAnagram(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if (ch1.length != ch2.length) {
            return false;
        }
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }

    // using two array of integer
    public static boolean isAnagram1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int a[] = new int[NO_OF_CHARS];
        int b[] = new int[NO_OF_CHARS];
        Arrays.fill(a, 0);
        Arrays.fill(b, 0);

        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i)]++;
            b[s2.charAt(i)]++;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;

    }

    public static boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String st1 = "geeksforgeeks";
        String st2 = "geeksgeeksfors";

        boolean res = isAnagram2(st1, st2);
        if (res == true) {
            System.out.println(st1 + " " + st2 + " " + "are Anagram to each other");
        } else {
            System.out.println("Not Anagram");
        }
    }
}