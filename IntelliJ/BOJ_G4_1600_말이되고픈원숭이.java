import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_G4_1600_말이되고픈원숭이 {
    static int K, W, H;
    static int[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] dEx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dEy = {2, -2, -1, 1, 2, -2, 1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0}); // y, x, idx, k -> 2, 1, 3,
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == H - 1 && p[1] == W - 1) return p[2];
            int ny, nx;
            for (int i = 0; i < 4; i++) {
                ny = p[0] + dy[i];
                nx = p[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visited[ny][nx][p[3]]) continue;
                visited[ny][nx][p[3]] = true;
                q.offer(new int[]{ny, nx, p[2] + 1, p[3]});
            }
            for (int i = 0; i < 8; i++) {
                ny = p[0] + dEy[i];
                nx = p[1] + dEx[i];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visited[ny][nx][p[3]]) continue;
                if (p[3] + 1 <= K && !visited[ny][nx][p[3] + 1]) {
                    visited[ny][nx][p[3] + 1] = true;
                    q.offer(new int[]{ny, nx, p[2] + 1, p[3] + 1});

                }
            }
        }
        return -1;
    }
}
