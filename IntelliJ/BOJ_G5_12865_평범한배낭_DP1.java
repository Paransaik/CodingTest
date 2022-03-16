import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G5_12865_평범한배낭_DP1 {
    static int N, K;
    static int[][] dp, items;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // R
        K = Integer.parseInt(st.nextToken()); // C

        dp = new int[N + 1][K + 1];
        items = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // 무게
            items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (items[i][0] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
            }
        }
        System.out.println(dp[N][K]);
    }
}