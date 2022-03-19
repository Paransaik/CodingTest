import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ____BOJ_S1_9205_맥주마시면서걸어가기 {
    static int N, c;
    static int[][] map;
    static String ans;
    static Queue<Position> q = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int ALPHA = 32768;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            q.clear();
            map = new int[1 << 16][1 << 16];
            N = Integer.parseInt(br.readLine());
            c = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) + ALPHA;
            int x = Integer.parseInt(st.nextToken()) + ALPHA;
            map[y][x] = 1; // start 위치 마킹
            for (int i = 0; i < c; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken()) + ALPHA][Integer.parseInt(st.nextToken()) + ALPHA] = 2; // 편의점 위치 마킹
            }
            map[Integer.parseInt(st.nextToken()) + ALPHA][Integer.parseInt(st.nextToken()) + ALPHA] = 3; // End 위치 마킹
            ans = bfs(y, x);
            bw.append(ans).append("\n");
        }
    }

    public static String bfs(int y, int x) {
        q.offer(new Position(y, x, 1000));

        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                // 도착 체크
                if (map[ny][nx] == 3) return "happy"; // y, x 축이 일치하면 true 리턴

                // 50미터 맥주 한캔 캬~
                p.life -= Math.abs(dx[i]) + Math.abs(dy[i]);

                // 갔는데 편의점이네?
                if (map[ny][nx] == 2) p.life = 1000;
                // life 가 0이면 끝
                if (p.life == 0) continue;

                if (ny < 0 || nx < 0 || ny >= 1 << 16 || nx >= 1 << 16 || map[ny][nx] == 1) continue;
                map[ny][nx] = 1;
                q.offer(new Position(ny, nx, p.life));
            }
        }
        return "sad";
    }

    public static class Position {
        int y;
        int x;
        int life;

        public Position(int y, int x, int life) {
            this.y = y;
            this.x = x;
            this.life = life;
        }
    }
}