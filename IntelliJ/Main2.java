import java.io.*;
import java.util.*;

public class Main2 {
    static int R, C;
    static int[][] map;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            int y = 0, x = 0;
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        y = i;
                        x = j;
                    }
                }
            }
            int ans = bfs(y, x);
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }

    public static int bfs(int y, int x) {
        boolean[][] visited = new boolean[R][C];
        PriorityQueue<Point> q = new PriorityQueue<>();
        visited[y][x] = true;
        q.offer(new Point(y, x, 0));

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (map[p.y][p.x] == 3) {
                ans = Math.min(p.l, ans);
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int nx = p.x + dx[i];
                if (nx < 0 || nx >= C || visited[p.y][nx] || map[p.y][nx] == 0) continue;
                q.offer(new Point(p.y, nx, p.l));
                visited[p.y][nx] = true;
            }

            for (int i = 1; i < R; i++) {
                for (int j = 2; j < 4; j++) {
                    int ny = p.y + dy[j] * i;
                    if (ny < 0 || ny >= R || visited[ny][p.x] || map[ny][p.x] == 0) continue;
                    q.offer(new Point(ny, p.x, Math.max(p.l, i)));
                }
            }

        }
        return ans;
    }

    public static class Point implements Comparable<Point> {
        int y;
        int x;
        int l;

        @Override
        public int compareTo(Point o) {
            if (this.l == o.l) {
                return (this.y == o.y) ? o.x - this.x : o.y - this.y;
            } else return this.l - o.l;
        }

        public Point(int y, int x, int l) {
            this.y = y;
            this.x = x;
            this.l = l;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    ", l=" + l +
                    '}';
        }
    }
}
