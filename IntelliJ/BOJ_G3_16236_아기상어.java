import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_16236_아기상어 {
    static int size;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        int y = 0, x = 0;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    y = i;
                    x = j;
                }
            }
        }

        System.out.println(bfs(y, x));
    }

    // 위, 왼쪽, 오른쪽, 아래
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static int bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[size][size];
        visited[s][e] = true;
        q.offer(new int[]{s, e, 2, 0}); // s, e, size, time
        int ans = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            int sharkSize = node[2];
            int time = node[3];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= size || nx >= size || map[ny][nx] > sharkSize || visited[ny][nx]) continue;

                if (map[ny][nx] != 0 && map[ny][nx] <= sharkSize) {
                    map[ny][nx] = 0;
                    visited = new boolean[size][size];
                    q.offer(new int[]{ny, nx, sharkSize + 1, time + 1});
                    ans += time + 1;
                }

                q.offer(new int[]{ny, nx, sharkSize, time + 1});
                visited[ny][nx] = true;
            }

            for (int j = 0; j < size; j++) {
                System.out.println(Arrays.toString(visited[j]));
            }
            System.out.println(ans);
        }

        return ans;
    }
}
