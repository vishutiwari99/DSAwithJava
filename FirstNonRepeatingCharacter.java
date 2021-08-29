import java.util.Arrays;

public class FirstNonRepeatingCharacter {

    public static void FirstNonRepeatingChara(String str) {
        int[] h = new int[26];
        Arrays.fill(h, 0);

        for (int i = 0; i < str.length(); i++) {
            h[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (h[str.charAt(i) - 'a'] == 1) {
                System.out.println(str.charAt(i));
                break;
            }
        }

    }

    public static void main(final String[] args) {
        String s = "hello";
        FirstNonRepeatingChara(s);

    }
}