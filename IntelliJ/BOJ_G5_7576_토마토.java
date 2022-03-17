import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_7576_토마토 {
    static int R, C, days;
    static int[][] map;

    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2022.03.18. 민하은!
        if (isRipe()) {
            System.out.println(0);
            return;
        }
        else {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 1) q.offer(new int[]{i, j, 0});
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
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] != 0) continue;
                map[ny][nx] = 1;
                q.offer(new int[]{ny, nx, p[2] + 1});
                days = Math.max(days, p[2] + 1);
            }
        }
    }

    private static boolean isRipe() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }

    public static boolean isChecked() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
