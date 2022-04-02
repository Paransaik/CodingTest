import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2589_보물섬 {
    static int R, C;
    static char[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    q.clear();
                    q.offer(new int[]{i, j, 0});
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int m, int n) {
        int ans = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[R][C];
        visited[m][n] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int y = p[0];
            int x = p[1];
            int time = p[2];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'W' || visited[ny][nx]) continue;
                q.offer(new int[]{ny, nx, time + 1});
                visited[ny][nx] = true;
                ans = Math.max(ans, time + 1);
            }
        }
        return ans;
    }
}