import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S1_6064_카잉달력 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int ans = X;
            int y = ((X - 1) % N) + 1;
            boolean check = false;
            for (int i = 0; i < N; i++) {
                if (y == Y) {
                    check = true;
                    break;
                }
                y = ((y + M - 1) % N) + 1;
                ans += M;
            }
            if (check) bw.append(String.valueOf(ans)).append("\n");
            else bw.append("-1").append("\n");
        }
        bw.flush();
    }
}