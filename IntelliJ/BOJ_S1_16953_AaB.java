import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_16953_AaB {
    static long N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        System.out.println(bfs());
    }

    public static long bfs() {
        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{1, N});
        while (!q.isEmpty()) {
            long[] num = q.poll();
            if (num[1] == M) return num[0];
            if (num[1] * 2 > M) continue;
            q.offer(new long[]{num[0] + 1, num[1] * 2});
            if (num[1] * 10 + 1 > M) continue;
            q.offer(new long[]{num[0] + 1, num[1] * 10 + 1});
        }
        return -1;
    }
}
