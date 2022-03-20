import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_6593_상범빌딩 {
    static int L, R, C;
    static char[][][] map;

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L + R + C == 0) break;

            map = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    map[i][j] = br.readLine().toCharArray();
                }
                br.readLine();
            }

            OUTER:
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S') {
                            int maze = bfs(i, j, k);
                            if (maze == 0) bw.append("Trapped!").append("\n");
                            else
                                bw.append("Escaped in ").append(String.valueOf(maze)).append(" minute(s).").append("\n");
                            break OUTER;
                        }
                    }
                }
            }
        }
        bw.flush();
    }

    public static int bfs(int l, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{l, y, x, 0});
        map[l][y][x] = '#';

        while (!q.isEmpty()) {
            int lct[] = q.poll();
            int f = lct[0];
            int r = lct[1];
            int c = lct[2];
            int t = lct[3];
            for (int i = 0; i < 6; i++) {
                int nz = f + dz[i];
                int ny = r + dy[i];
                int nx = c + dx[i];

                if (nz < 0 || ny < 0 || nx < 0 ||
                        nz >= L || ny >= R || nx >= C ||
                        map[nz][ny][nx] == '#') continue;

                if (map[nz][ny][nx] == 'E') return t + 1;
                q.offer(new int[]{nz, ny, nx, t + 1});
                map[nz][ny][nx] = '#';
            }
        }
        return 0;
    }
}
