public class Power {

    public static int pow(int x, int y) {
        if (x == 0) {
            return 0;
        }
        if (y == 0) {
            return 1;
        }
        int temp = pow(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }

    }

    public static int pow1(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int temp = pow1(x, y - 1);
        int xn = temp * x;
        return xn;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        System.out.println(pow1(x, y));
        // pow(x, y);
    }
}