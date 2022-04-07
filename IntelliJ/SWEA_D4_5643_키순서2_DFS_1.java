import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_5643_키순서2_DFS_1 {
    static final int INF = 99999;
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
            adjMatrix = new int[N][N];

            M = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) Arrays.fill(adjMatrix[i], INF);

            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from - 1][to - 1] = 1;
            }

            for (int[] matrix : adjMatrix) {
                System.out.println(Arrays.toString(matrix));
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                gtCnt = ltCnt = 0;
                gtDFS(i, new boolean[N]);
                ltDFS(i, new boolean[N]);
                if (gtCnt + ltCnt == N - 1) ++ans;
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }

    static int gtCnt = 0, ltCnt = 0;

    public static void gtDFS(int cur, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < N; i++) {
            if (adjMatrix[cur][i] == 1 && !visited[i]) {
                ++gtCnt;
                gtDFS(i, visited);
            }
        }
    }

    public static void ltDFS(int cur, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < N; i++) {
            if (adjMatrix[i][cur] == 1 && !visited[i]) {
                ++gtCnt;
                gtDFS(i, visited);
            }
        }
    }
}