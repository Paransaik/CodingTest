import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_S4_2407_조합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        b = Math.max(b, a - b);
        BigInteger u = BigInteger.ONE;
        BigInteger d = BigInteger.ONE;

        for (int i = a; i > b; i--) {
            u = u.multiply(BigInteger.valueOf(i));
        }
        for (int i = 2, len = a - b; i <= len; i++) {
            d = d.multiply(BigInteger.valueOf(i));
        }
        System.out.println(u.divide(d));
    }
}
