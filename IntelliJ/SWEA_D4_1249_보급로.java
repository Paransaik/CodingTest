import java.io.*;
import java.util.PriorityQueue;

public class SWEA_D4_1249_보급로 {
    static int N;
    static char[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(bfs())).append("\n");
        }
        bw.flush();
    }

    public static int bfs() {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = n.y + dy[i];
                int nx = n.x + dx[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx]) continue;
                int weight = map[ny][nx] - '0';
                q.offer(new Node(ny, nx, n.w + weight));
                visited[ny][nx] = true;

                if (ny == N - 1 && nx == N - 1) return n.w + weight;
            }
        }
        return 0;
    }

    public static class Node implements Comparable<Node> {
        int y;
        int x;
        int w;

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

        public Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }
}
