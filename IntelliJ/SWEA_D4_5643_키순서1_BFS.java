import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_5643_키순서1_BFS {
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

            for (int[] matrix : adjMatrix) {
                System.out.println(Arrays.toString(matrix));
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if (gtBFS(i, new boolean[N]) + ltBFS(i, new boolean[N]) == N - 1) ++ans;
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }

    public static int gtBFS(int start, boolean[] visited) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            // 모든 학생 들을 보며 자신보다 키가 큰 학생 따라 탐색
            for (int i = 0; i < N; i++) {
                if (adjMatrix[cur][i] == 1 && !visited[i]) {
                    ++cnt;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return cnt;
    }

    public static int ltBFS(int start, boolean[] visited) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            // 모든 학생 들을 보며 자신보다 키가 작은 학생 따라 탐색
            for (int i = 0; i < N; i++) {
                if (adjMatrix[i][cur] == 1 && !visited[i]) {
                    ++cnt;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return cnt;
    }
}
