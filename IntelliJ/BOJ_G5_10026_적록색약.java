import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_G5_10026_적록색약 {
    static int N, ans1 = 0, ans2 = 0;
    static char[][] map, mapCopy;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        mapCopy = new char[N][N];
        for (int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                mapCopy[i][j] = map[i][j];
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 'A') ans1 += bfs1(i, j, map[i][j]);
                if (mapCopy[i][j] != 'A') ans2 += bfs2(i, j, mapCopy[i][j]);
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    public static int bfs1(int y, int x, char ahpa) {
        LinkedList<Position> q = new LinkedList<>();
        q.offer(new Position(y, x, ahpa));
        boolean[][] visited = new boolean[N][N];
        map[y][x] = 'A';
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[ny][nx] == 'A') continue;
                if (map[ny][nx] == p.alpha) {
                    map[ny][nx] = 'A';
                    visited[ny][nx] = true;
                    q.offer(new Position(ny, nx, p.alpha));
                }
            }
        }
        return 1;
    }

    public static int bfs2(int y, int x, char ahpa) {
        LinkedList<Position> q = new LinkedList<>();
        q.offer(new Position(y, x, ahpa));
        boolean[][] visited = new boolean[N][N];
        mapCopy[y][x] = 'A';
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || mapCopy[ny][nx] == 'A') continue;
                if (p.alpha == 'R' || p.alpha == 'G'){
                    if(mapCopy[ny][nx] == 'R' || mapCopy[ny][nx] == 'G'){
                        mapCopy[ny][nx] = 'A';
                        visited[ny][nx] = true;
                        q.offer(new Position(ny, nx, p.alpha));
                    }
                } else if (p.alpha == mapCopy[ny][nx]) {
                    mapCopy[ny][nx] = 'A';
                    visited[ny][nx] = true;
                    q.offer(new Position(ny, nx, p.alpha));
                }

            }
        }
        return 1;
    }

    public static class Position {
        int y;
        int x;
        char alpha;

        public Position(int y, int x, char alpha) {
            this.y = y;
            this.x = x;
            this.alpha = alpha;
        }
    }
}