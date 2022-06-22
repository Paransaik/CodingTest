import java.util.Scanner;

public class BOJ_S3_9461_파도반수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        long dp[] = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i < 101; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        while (tc-- > 0) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
