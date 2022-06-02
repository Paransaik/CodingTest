import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14500_테트로미노 {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                fuck(i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void dfs(int y, int x, int s, int l) {
        if (l == 4) {
            max = Math.max(max, s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, s + map[y][x], l + 1);
            visited[ny][nx] = false;
        }
    }

    public static void fuck(int y, int x) {
        if (1 <= x && x < C - 1) {
            // ㅗ
            if (1 <= y) max = Math.max(max, map[y][x - 1] + map[y][x] + map[y][x + 1] + map[y - 1][x]);
            // ㅜ
            if (y < R - 1) max = Math.max(max, map[y][x - 1] + map[y][x] + map[y][x + 1] + map[y + 1][x]);
        }
        if(1 <= y && y < R - 1){
            // ㅓ
            if (1 <= x) max = Math.max(max, map[y - 1][x] + map[y][x] + map[y + 1][x] + map[y][x - 1]);
            // ㅏ
            if (x < C - 1) max = Math.max(max, map[y - 1][x] + map[y][x] + map[y + 1][x] + map[y][x + 1]);
        }
    }
}
