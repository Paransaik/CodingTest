import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_5643_키순서 {
    static final int INF = 99999;
    static int N, M, adjMatrix[][];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            adjMatrix = new int[N][N];

            M = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) Arrays.fill(adjMatrix[i], INF);

            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from - 1][to - 1] = 1;
            }

            for (int k = 0; k < N; ++k) {
                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < N; ++j) {
                        int sum = adjMatrix[i][k] + adjMatrix[k][j];
                        if (i != j && adjMatrix[i][j] > sum ) {
                            adjMatrix[i][j] = sum;
                        }
                    }
                }
            }
            int ans = 0;
            boolean flag;
            for (int i = 0; i < N; i++) {
                flag = true;
                for (int j = 0; j < N; j++) {
                    if (i != j && ((adjMatrix[i][j] & adjMatrix[j][i]) == INF)) flag = false;
                }
                if (flag) ans++;
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }
}
