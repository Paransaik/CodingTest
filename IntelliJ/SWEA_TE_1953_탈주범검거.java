import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_TE_1953_탈주범검거 {
    static int R, C, r, c, L;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

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
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            bfs(r, c);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (visited[i][j] == true) ans++;
                }
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }

    public static void bfs(int startY, int statyX) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[R][C];
        q.offer(new int[]{startY, statyX, 1});
        visited[startY][statyX] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int y = p[0];
            int x = p[1];
            int t = p[2];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 0 || visited[ny][nx] || t >= L) continue;
                int s = map[ny][nx];
                if (ny == y + 1) {
                    if (s == 3 || s == 5 || s == 6) continue;
                } else if (ny == y - 1) {
                    if (s == 3 || s == 4 || s == 7) continue;
                } else if (nx == x + 1) {
                    if (s == 2 || s == 4 || s == 5) continue;
                } else if (nx == x - 1) {
                    if (s == 2 || s == 6 || s == 7) continue;
                }
                switch (map[y][x]) {
                    case 1:
                        q.offer(new int[]{ny, nx, t + 1});
                        visited[ny][nx] = true;
                        break;
                    case 2:
                        if (nx != x) continue;
                        q.offer(new int[]{ny, nx, t + 1});
                        visited[ny][nx] = true;
                        break;
                    case 3:
                        if (ny != y) continue;
                        q.offer(new int[]{ny, nx, t + 1});
                        visited[ny][nx] = true;
                        break;
                    case 4:
                        if (ny == y - 1 && nx == x) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        } else if (ny == y && nx == x + 1) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        }
                        break;
                    case 5:
                        if (ny == y + 1 && nx == x) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        } else if (ny == y && nx == x + 1) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        }
                        break;
                    case 6:
                        if (ny == y + 1 && nx == x) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        } else if (ny == y && nx == x - 1) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        }
                        break;
                    case 7:
                        if (ny == y - 1 && nx == x) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        } else if (ny == y && nx == x - 1) {
                            q.offer(new int[]{ny, nx, t + 1});
                            visited[ny][nx] = true;
                        }
                        break;
                }
            }
        }
    }
}
