import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D3_5215_햄버거다이어트 {
    static int N, K;
    static int[] dp;
    static int[][] items;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // R
            K = Integer.parseInt(st.nextToken()); // C

            dp = new int[K + 1];
            items = new int[N + 1][2];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                items[i][1] = Integer.parseInt(st.nextToken()); // 무게
                items[i][0] = Integer.parseInt(st.nextToken()); // 가치
            }

            for (int i = 1; i <= N; i++) {
                for (int j = K; j >= items[i][0]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
                }
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(dp[K])).append("\n");
        }
        bw.flush();
    }
}