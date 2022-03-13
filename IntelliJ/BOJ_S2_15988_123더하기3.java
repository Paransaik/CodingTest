import java.io.*;

public class BOJ_S2_15988_123더하기3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int[] dp = {1, 2, 4};
            int N = Integer.parseInt(br.readLine());

            for (int i = 1; i <= N - 3; i++) {
                dp[(i - 1) % 3] = ((dp[0] + dp[1]) % 1000000009 + dp[2]) % 1000000009;
            }
            bw.append(String.valueOf(dp[(N - 1) % 3])).append("\n");
        }
        bw.flush();
    }
}