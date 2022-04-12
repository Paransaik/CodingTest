import java.util.Scanner;

public class BOJ_S3_1929_소수구하기 {

    static final int MAX = 1000000;
    static boolean[] prime = new boolean[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sieve();
        prime[1] = true;
        for (int i = a; i <= b; i++) {
            if (!prime[i]) System.out.println(i);
        }

    }

    public static void sieve() {
        for (int i = 2; i * i <= MAX + 1; i++) {
            for (int j = i + i; j < MAX + 1; j += i) {
                prime[j] = true;
            }
        }
    }
}
