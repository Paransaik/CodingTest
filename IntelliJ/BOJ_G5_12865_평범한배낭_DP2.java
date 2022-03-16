import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_12865_평범한배낭_DP2 {
    static int N, K;
    static int[] dp;
    static int[][] items;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // R
        K = Integer.parseInt(st.nextToken()); // C

        dp = new int[K + 1];
        items = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // 무게
            items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= items[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
            }
        }
        System.out.println(dp[K]);
    }
}