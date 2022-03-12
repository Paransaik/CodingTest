import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ____BOJ_G4_14466_소가길을건너간이유6 {
    static int N, K, R;
    static int ans = 0, cnt = 0;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map, road, cow;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        Queue<int[]> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N*N map
        K = Integer.parseInt(st.nextToken()); // 소의 수
        R = Integer.parseInt(st.nextToken()); // 길의 개수
        map = new int[N][N];
        visited = new boolean[N][N];
        cow = new int[K][2];
        road = new int[R][4];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
            road[i][2] = Integer.parseInt(st.nextToken());
            road[i][3] = Integer.parseInt(st.nextToken());
        }

        // 소의 좌표를 queue에 넣음
        int y, x;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
            cow[i][0] = y;
            cow[i][1] = x;
        }

        for (int i = 0; i < K; i++) {
            q.offer(new int[]{cow[i][0], cow[i][1]});
            visited[cow[i][0]][cow[i][1]] = true;
            bfs();
        }
        bw.append(String.valueOf(ans / 2));
        bw.flush();
    }

    // 시작 소를 기준으로 n-1번만큼 반복해야 됨.
    //
    public static void bfs() {
        int flag;
        int[] node;
        while (!q.isEmpty()) {
            flag = 0;
            node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] == true) continue;
                for (int j = 0; j < R; j++) {
//                    if() // x, y, dx, dy가 같으면 flag = 1;
                    if (road[j][1] == node[0] && road[j][0] == node[1] && road[j][2] == ny && road[j][3] == nx) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        ans += N - 1 - cnt;
    }
}
