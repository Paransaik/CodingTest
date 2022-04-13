import java.util.Scanner;

public class BOJ_S3_1929_소수구하기_BIT {

    static final int MAX = 1000000;
    static final int len = MAX / 8 + 1;
    static byte[] prime = new byte[len];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < len; i++) {
            prime[i] = (byte) 255;
        }
        prime[0] = (byte) (prime[0] & ~(3));
        sieve();
        for (int i = a; i <= b; i++) {
            if ((prime[i >> 3] & (1 << (i % 8))) > 1){
                System.out.println(i);
            }
        }
    }

    public static void sieve() {
        for (int i = 2; i * i <= MAX + 1; i++) {
            for (int j = i + i; j < MAX + 1; j += i) {
                prime[j >> 3] &= ~(1 << j % 8);
            }
        }
    }
}
