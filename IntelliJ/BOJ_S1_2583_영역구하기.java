import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_S1_2583_영역구하기 {
    static int R, C, K;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> l = new LinkedList<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    if (map[j][k] == 0) map[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                    l.add(bfs(i, j));
                }
            }
        }

        Collections.sort(l);

        bw.append(String.valueOf(cnt)).append("\n");
        for (Integer integer : l) {
            bw.append(String.valueOf(integer)).append(" ");
        }
        bw.flush();
    }

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, 1});
        map[y][x] = 1;
        int size = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] != 0) continue;

                map[ny][nx] = 1;
                q.offer(new int[]{ny, nx, node[2] + 1});
                size++;
            }
        }
        return size;
    }
}
