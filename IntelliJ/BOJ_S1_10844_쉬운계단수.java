import java.util.Scanner;

public class BOJ_S1_10844_쉬운계단수 {
    final static int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[][] dp = new int[101][10];

        for (int i = 1; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i <= a; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j < 9; j++) {
                dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) sum = (sum + dp[a][i]) % MOD;

        System.out.println(sum);
    }
}