import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14501_퇴사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(i + idx <= n) {
                int updateWeight = Math.max(dp[i + idx], dp[i] + weight);
                for (int j = i + idx; j <= n; j++) {
                    dp[j] = Math.max(dp[j], updateWeight);
                }
            }
            map[i][0] = idx;
            map[i][1] = dp[i] + weight;
        }
        System.out.println(dp[n]);
    }
}
