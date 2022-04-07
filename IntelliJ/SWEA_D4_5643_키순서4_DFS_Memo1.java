import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_5643_키순서4_DFS_Memo1 {
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

            // 탐색 전을 나타내는 의미로 초기화
            for (int i = 1; i <= N; i++) adjMatrix[i][0] = -1;

            M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = 1;
            }

            for (int i = 1; i <= N; i++) {
                // 탐색 전인 학생들만 탐색
                if (adjMatrix[i][0] == -1) gtDFS(i);
            }

            // 자신보다 작은 학생 수 카운트
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    adjMatrix[0][i] += adjMatrix[j][i];
                }
            }

            for (int[] matrix : adjMatrix) {
                System.out.println(Arrays.toString(matrix));
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (adjMatrix[i][0] + adjMatrix[0][i] == N - 1) ++ans;
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }

    public static void gtDFS(int cur) {
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[cur][i] == 1) {// 나보다 큰 학생이면
                if (adjMatrix[i][0] == -1) gtDFS(i); // 탐색 전이면 탐색하러 가기
                if (adjMatrix[i][0] > 0) { // i보다 큰 학생이 있다면
                    // 나보다 큰 학생이 알고 있는 다른 학생들과 의 키 관계를 나와의 직접 관계로 맵핑
                    // cur < i < j ==> cur < j
                    for (int j = 0; j < N; j++) {
                        if (adjMatrix[i][j] == 1) {
                            adjMatrix[cur][j] = 1;

                        }
                    }

                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += adjMatrix[cur][i];
        }
        adjMatrix[cur][0] = cnt;
    }
}