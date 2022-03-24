import java.util.Scanner;

public class BOJ_S3_11726_2xn타일링 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        dp = new int[1001];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < a+1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[a]);
    }
}
