import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_B5_15964_이상한기호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        System.out.println(a.multiply(a).subtract(b.multiply(b)));
    }
}
