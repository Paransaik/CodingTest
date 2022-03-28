import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_7569_토마토 {
    static int R, C, H, days;
    static int[][][] map;

    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][R][C];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 2022.03.18. 민하은!
        if (isRipe()) {
            System.out.println(0);
            return;
        }
        else {
            for (int k = 0; k < H; k++) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[k][i][j] == 1) q.offer(new int[]{i, j, k, 0});
                    }
                }
            }
            bfs();
        }
        if (isChecked()) System.out.println(days);
        else System.out.println(-1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 6; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                int nz = p[2] + dz[i];
                if (ny < 0 || nx < 0 || nz < 0 ||
                        ny >= R || nx >= C || nz >= H ||
                        map[nz][ny][nx] != 0) continue;
                map[nz][ny][nx] = 1;
                q.offer(new int[]{ny, nx, nz, p[3] + 1});
                days = Math.max(days, p[3] + 1);
            }
        }
    }

    private static boolean isRipe() {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[k][i][j] != 1) return false;
                }
            }
        }
        return true;
    }

    public static boolean isChecked() {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[k][i][j] == 0) return false;
                }
            }
        }
        return true;
    }
}
