
public class DifferenceCharacters {

    public static String solution1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i) - str.charAt(i - 1);
            if (i - 1 > 0) {
                sb.append(diff);
                sb.append(str.charAt(i));
            } else {
                sb.append(str.charAt(i - 1));
                sb.append(diff);
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String solution2(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            int diff = curr - prev;
            sb.append(diff);
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aabd";
        System.out.println(solution1(str));
    }
}