import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2638_치즈 {
    static int R, C, ny, nx, cheese = 0;
    static int[][] map;

    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }

        int time = 0;
        while (cheese > 0) {
            time++;
            meltCheese();
        }
        System.out.println(time);
    }

    public static void meltCheese() {
        q.offer(new int[]{0, 0});
        boolean[][][] visited = new boolean[R][C][2];
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] posi = q.poll();
            for (int i = 0; i < 4; i++) {
                ny = posi[0] + dy[i];
                nx = posi[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx][0]) continue;
                if (map[ny][nx] == 1) {
                    if (visited[ny][nx][1]) {
                        visited[ny][nx][0] = true;
                        map[ny][nx] = 0;
                        cheese--;
                    } else visited[ny][nx][1] = true;
                } else {
                    visited[ny][nx][0] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
}