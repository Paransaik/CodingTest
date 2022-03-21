import java.util.Scanner;

public class BOJ_S4_17626_FourSquares {
     public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] dp = new int[a + 1];
        dp[1] = 1;
        for (int i = 1; i <= a; i++) {
            dp[i] = 1 + dp[i - 1];
            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        System.out.println(dp[a]);
    }
}
