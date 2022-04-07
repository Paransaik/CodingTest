import com.sun.corba.se.impl.oa.poa.AOMEntry;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_D4_1249_보급로1_Dijkstra {
    static final int INF = 100000;
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
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(dijkstra(0, 0))).append("\n");

        }
        bw.flush();
    }

    public static int dijkstra(int startR, int startC) {
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minTime[i][j] = INF;
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>(){
            // 오름차순
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });

        minTime[startR][startC] = 0;
        q.offer(new Node(startR, startC, minTime[startR][startC]));

        int nr, nc;
        Node current;
        while (true) {
            current = q.poll(); // pQueue 안의 정점 중 출발지에서 자신으로의 비용이 최소인 정점의 정보

            if (visited[current.y][current.x]) continue;

            visited[current.y][current.x] = true;

            // 도착지라면 끝내기
            if (current.y == N -1 && current.x == N-1) return current.w;

            // 현 정점의 인접정점 들여다 보며 최소비용 갱신
            for (int i = 0; i < 4; i++) {
                nr = current.y + dy[i];
                nc = current.x + dx[i];

                if(nr >= 0 && nc >= 0 && nr < N && nc < N
                && minTime[nr][nc] > current.w + map[nr][nc]) { // !visited[nr][nc] 생략 가능
                    minTime[nr][nc] = (char) (current.w + map[nr][nc] - '0');
                    q.offer(new Node(nr, nc, minTime[nr][nc]));
                }
            }
        }
    }

    public static class Node {
        int y;
        int x;
        int w;

        public Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }
}
