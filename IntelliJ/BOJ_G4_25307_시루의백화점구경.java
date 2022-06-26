import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_25307_시루의백화점구경 {
    static Queue<int[]> q = new LinkedList<>();
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        int y = 0, x = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (map[i][j] == 3) q.offer(new int[]{i, j, 0});
                if (map[i][j] == 4) {
                    y = i;
                    x = j;
                }
            }
        }

        mannequin();
        System.out.println(bfs(y, x));
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void mannequin() {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || node[2] >= K || visited[ny][nx]) continue;
                if (map[ny][nx] == 0 || map[ny][nx] == 2) map[ny][nx] = 3;
                q.offer(new int[]{ny, nx, node[2] + 1});
                visited[ny][nx] = true;
            }
        }
    }

    public static int bfs(int y, int x) {
        q = new LinkedList<>();
        q.offer(new int[]{y, x, 0});
        visited = new boolean[N][N];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 1 || map[ny][nx] == 3 || visited[ny][nx])
                    continue;
                q.offer(new int[]{ny, nx, node[2] + 1});
                visited[ny][nx] = true;
                if (map[ny][nx] == 2) return node[2] + 1;
            }
        }
        return -1;
    }
}