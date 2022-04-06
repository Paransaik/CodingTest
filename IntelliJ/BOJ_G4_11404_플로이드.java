import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G4_11404_플로이드 {
    static int N;
    static final int INF = 10000001;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) map[i][j] = INF;
                else map[i][j] = 0;
            }
        }
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            if (map[from][to] == INF) map[from][to] = weight;
            else map[from][to] = Math.min(map[from][to], weight);
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == INF) bw.append("0 ");
                else bw.append(String.valueOf(map[i][j])).append(" ");
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
