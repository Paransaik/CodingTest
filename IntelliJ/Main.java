import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-2, -1, 1, 2, 1, -1};
    static int[] dx = {0, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            map = new int[R * 2][C];
            for (int i = 0; i < R * 2; i += 2) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    if (j % 2 == 0) map[i][j] = Integer.parseInt(st.nextToken());
                    else map[i + 1][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int[] ints : map) {
                System.out.println(Arrays.toString(ints));
            }
            visited = new boolean[R * 2][C];
            long ans = 0;
            for (int i = 0; i < R*2; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] != 0) {
                        dfs(1, i, j, map[i][j]);
                        ans = Math.max(dfsSum, ans);
                    }
                }
            }
            System.out.println(ans);
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans * ans)).append("\n");
        }
        bw.flush();
    }

    static int dfsSum = Integer.MIN_VALUE;

    public static void dfs(int cnt, int y, int x, int sum) {
        if (cnt == 4) {
            dfsSum = Math.max(sum, dfsSum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= R * 2 || nx >= C || visited[ny][nx]) continue;
            sum += map[ny][nx];
            visited[ny][nx] = true;
            dfs(cnt + 1, ny, nx, sum);
            visited[ny][nx] = false;
            sum -= map[ny][nx];
        }
        return;
    }
}

