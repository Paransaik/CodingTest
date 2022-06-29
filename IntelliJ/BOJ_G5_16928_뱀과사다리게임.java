import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_16928_뱀과사다리게임 {
    static int N, M;
    static int[][] map = new int[101][2];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            map[num][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs());
    }


    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] step = q.poll();
            int x = step[0];
            for (int i = 1; i < 7; i++) {
                int nx = x + i;
                if (nx > 100 || visited[nx]) continue;
                if (map[nx][1] != 0) {
                    q.offer(new int[]{map[nx][1], step[1] + 1});
                    visited[map[nx][1]] = true;
                } else {
                    q.offer(new int[]{nx, step[1] + 1});
                    visited[nx] = true;
                }
                if (nx == 100) return step[1] + 1;
            }
        }
        return 0;
    }
}