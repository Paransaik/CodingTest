import java.util.Scanner;

public class BOJ_S3_2579_계단오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] step = new int[301], dp = new int[301];
        for (int i = 1; i <= n; i++) step[i] = sc.nextInt();
        dp[1] = step[1];
        dp[2] = step[2] + step[1];
        for (int i = 3; i < 301; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i - 1]) + step[i];
        }
        System.out.println(dp[n]);
    }
}
