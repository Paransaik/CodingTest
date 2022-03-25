import java.util.Scanner;

public class BOJ_S3_1463_1만들기 {
    public static final int MAX = 1000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[MAX];
        int a = sc.nextInt();
        dp[2] = dp[3] = 1;
        for (int i = 4; i < MAX; i++) {
            if (i % 2 == 0 && i % 3 == 0) dp[i] = Math.min(Math.min(dp[i - 1], dp[i / 2]), dp[i / 3]) + 1;
            else if (i % 2 == 0) dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            else if (i % 3 == 0) dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            else dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[a]);
    }
}