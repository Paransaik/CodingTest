import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ____BOJ_S1_9205_맥주마시면서걸어가기 {
    static int N, sY, sX, y, x, eY, eX;
    static String ans;
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

            st = new StringTokenizer(br.readLine());
            sY = Integer.parseInt(st.nextToken());
            sX = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                l.add(new Position(y, x));
            }
            st = new StringTokenizer(br.readLine());
            eY = Integer.parseInt(st.nextToken());
            eX = Integer.parseInt(st.nextToken());

            bw.append((bfs())? "happy\n": "sad\n");
        }
    }

    public static boolean bfs() {

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