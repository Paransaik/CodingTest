import java.io.*;
import java.util.Arrays;

public class BOJ_S3_9095_123더하기 {
    static int N, cnt;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            dp(0);
            bw.append(String.valueOf(cnt)).append("\n");
        }
        bw.flush();
    }

    public static void dp(int n) throws Exception {
        if (n > N) return;
        if (n == N) {
            cnt++;
            return;
        }
        dp(n + 1);
        dp(n + 2);
        dp(n + 3);
    }
}