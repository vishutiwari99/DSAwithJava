import java.util.Arrays;

public class UncommonCharacter {
    static int MAX_CHAR = 26;

    public static void printUncommonCharacter(String str1, String str2) {
        int hash[] = new int[MAX_CHAR];
        Arrays.fill(hash, 0);

        for (int i = 0; i < str1.length(); i++) {
            hash[str1.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (hash[str2.charAt(i) - 'a'] == 1 || hash[str2.charAt(i) - 'a'] == -1) {
                hash[str2.charAt(i) - 'a'] = -1;
            } else {
                hash[str2.charAt(i) - 'a'] = 2;
            }
        }

        for (int i = 0; i < MAX_CHAR; i++) {
            if (hash[i] == 1 || hash[i] == 2) {
                System.out.println((char) (i + 'a') + "");
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "character";
        String str2 = "alphabet";
        UncommonCharacter.printUncommonCharacter(str1, str2);
    }
}