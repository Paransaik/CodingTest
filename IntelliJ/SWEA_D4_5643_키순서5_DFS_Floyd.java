import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_5643_키순서5_DFS_Floyd {
    static int N, M;
    static int[][] adjMatrix;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            adjMatrix = new int[N + 1][N + 1];

            M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = 1;
            }
            // ------------ 입력처리 ------------

            // 모든 쌍의 관계를 파악
            // 경 출 도
            for (int k = 1; k <= N; k++) { // 경유 학생
                for (int i = 1; i <= N; i++) { // 출발 학생(자신과 다른 학생과의 관계를 알고 싶은 학생)
                    if (i == k || adjMatrix[i][k] == 0) continue;
                    for (int j = 1; j <= N; j++) { // 도착 학생(다른 학생)
                        if (adjMatrix[i][j] == 1) continue;
                        if (adjMatrix[k][j] == 1) {
                            adjMatrix[i][j] = 1;
                        }
                    }
                }
            }
            // end: 알 수 있는 모든 쌍의 관계가 반영되어 있음.

            // 자신보다 크고 작은 학생 수 카운트
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    adjMatrix[i][0] += adjMatrix[i][j];
                    adjMatrix[0][j] += adjMatrix[i][j];
                }
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (adjMatrix[i][0] + adjMatrix[0][i] == N - 1) ++ans;
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }
}