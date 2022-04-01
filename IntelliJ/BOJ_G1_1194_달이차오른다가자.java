import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_1194_달이차오른다가자 {
    static int R, C;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C][1 << 7];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '0') {
                    q.offer(new int[]{i, j, 0, 0});
                    visited[i][j][0] = true;
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int ny, nx, bit;
            for (int i = 0; i < 4; i++) {
                ny = p[0] + dy[i];
                nx = p[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx][p[3]]) continue;
                char posi = map[ny][nx];
                if (posi == '.') {
                    visited[ny][nx][p[3]] = true;
                    q.offer(new int[]{ny, nx, p[2] + 1, p[3]});
                } else if ('a' <= posi && posi <= 'f') {
                    bit = p[3] | 1 << (posi - 'a');
                    if (!visited[ny][nx][bit]){
                        visited[ny][nx][bit] = true;
                        q.offer(new int[]{ny, nx, p[2] + 1, bit});
                    }
                } else if ('A' <= posi && posi <= 'F' && (p[3] & 1 << (posi - 'A')) > 0) {
                    q.offer(new int[]{ny, nx, p[2] + 1, p[3]});
                    visited[ny][nx][p[3]] = true;
                } else if (posi == '1') return p[2] + 1;
            }
        }
        return -1;
    }
}