import java.util.Scanner;

public class BOJ_S3_1904_01타일 {
    final static int MAX = 1000001;
    final static int MOD = 15746;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[MAX + 1];
        for (int i = 1; i < 4; i++) dp[i] = i;
        for (int i = 4; i < MAX + 1; i++) {
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
        }
        System.out.println(dp[sc.nextInt()]);
    }
}
