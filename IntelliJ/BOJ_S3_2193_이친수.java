import java.util.Scanner;

public class BOJ_S3_2193_이친수 {
    final static int MAX = 91;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[MAX];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < MAX; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] ;
        }
        System.out.println(dp[sc.nextInt()]);
    }
}
