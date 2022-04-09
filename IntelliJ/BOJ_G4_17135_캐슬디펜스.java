import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_17135_캐슬디펜스 {
    static int R, C, D, ans = Integer.MIN_VALUE;
    static int[][] map, copyMap;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 배치
        arrangeArcher(0, 0);
        System.out.println(ans);
    }


    public static void arrangeArcher(int start, int cnt) {
        if (cnt == 3) {
            copyMap = new int[R + 1][C];
            for (int i = 0; i <= R; i++) {
                for (int j = 0; j < C; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            int monster = 0;
            while (checkBorad(copyMap)) {
                // 2. 어택, 잡은 몬스터 수 계산
                monster += attackArcher();
                // 3. 무브
                monsterMove();
                // 4. 보드판 검사 후 몬스터가 있으면 2번으로, 없으면 5번으로
            }
            // 5. 몬스터 수 최댓값 갱신
            ans = Math.max(ans, monster);
            return;
        }

        // nC3의 궁수를 배치하는 경우의 수
        for (int i = start; i < C; i++) {
            map[R][i] = 5;
            arrangeArcher(i + 1, cnt + 1);
            map[R][i] = 0;
        }
    }

    static int[] dy = {0, 0, -1};
    static int[] dx = {-1, 1, 0};

    public static int attackArcher() {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < C; i++) {
            if (copyMap[R][i] == 5) {
                Point p = serachMonster(i);
                if (p != null) s.add((p.y << 4) + p.x);
            }
        }
        int cnt = s.size();
        for (Integer integer : s) {
            int row = integer >> 4;
            int col = integer & ((1 << 4) - 1);
            copyMap[row][col] = 0;
        }
        return cnt;
    }

    // 가장 가까운 거리, 왼쪽부터 몬스터 제거
    public static Point serachMonster(int x) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        visited = new boolean[R][C];
        q.offer(new Point(R - 1, x, 1));
        visited[R - 1][x] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (copyMap[p.y][p.x] == 1) return p;
            for (int i = 0; i < 3; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || nx < 0 || nx >= C || visited[ny][nx]) continue;
                if (p.d + 1 <= D) {
                    q.offer(new Point(ny, nx, p.d + 1));
                    visited[ny][nx] = true;
                }
            }
        }
        return null;
    }

    // 위에서 아래로 한칸씩 이동
    public static void monsterMove() {
        for (int i = R - 2; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                copyMap[i + 1][j] = copyMap[i][j];
            }
        }
        for (int i = 0; i < C; i++) {
            copyMap[0][i] = 0;
        }
    }

    // 몬스터가 있으면 true, 없으면 false
    public static boolean checkBorad(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) return true;
            }
        }
        return false;
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int d;

        @Override
        public int compareTo(Point o) {
            if (this.d == o.d) {
                return (this.x == o.x) ? o.y - this.y : this.x - o.x;
            } else return this.d - o.d;
        }

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}