import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_9205_맥주마시면서걸어가기 {
    static int N, y, x;
    static Queue<Position> q = new LinkedList<>();
    static ArrayList<Position> l = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            q.clear();
            l.clear();

            N = Integer.parseInt(br.readLine()); // 편의점 수
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                l.add(new Position(y, x));
            }
            bw.append((bfs()) ? "happy\n" : "sad\n");
        }
        bw.flush();
    }

    public static boolean bfs() {
        int len = l.size();
        boolean[] visited = new boolean[len];
        q.offer(l.get(0));
        visited[0] = true;
        while (!q.isEmpty()) {
            Position p = q.poll();

            int yP, xP;
            for (int i = 1; i < len; i++) {
                yP = l.get(i).y;
                xP = l.get(i).x;
                if (!visited[i] && Math.abs(p.x - xP) + Math.abs(p.y - yP) <= 1000) {
                    q.offer(new Position(yP, xP));
                    visited[i] = true;
                }
                if (visited[len - 1]) return true;
            }
        }
        return false;
    }

    public static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}