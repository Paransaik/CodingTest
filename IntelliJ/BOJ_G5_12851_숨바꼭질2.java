import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_G5_12851_숨바꼭질2 {
    static int N, K, ans = Integer.MAX_VALUE, method = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        visited = new boolean[K + 2];
        if (N != K) bfs(N);
        else ans = 0;
        System.out.println(ans);
        System.out.println(method);
    }

    public static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        int[] position;
        int pos, idx = 0;

        q.offer(new int[] { start, idx });
        while (!q.isEmpty()) {
            position = q.poll();
            pos = position[0];
            idx = position[1];
            System.out.println(pos);
            if (pos == K && ans >= idx) {
                ans = Math.min(idx, ans);
                method++;
            }
            int num = Math.max(N, K);
            if (pos <= num - 1 && !visited[pos + 1]) {
                q.offer(new int[] { pos + 1, idx + 1 });
                if (pos + 1 != K)  visited[pos + 1] = true;
            }
            if (pos <= (num + 1) / 2 && !visited[pos * 2]) {
                q.offer(new int[] { pos * 2, idx + 1 });
                if (pos * 2 != num) visited[pos * 2] = true;
            }
            if (pos > 0 && pos <= K + 1 && !visited[pos - 1]) {
                q.offer(new int[] { pos - 1, idx + 1 });
                if (pos - 1 != K) visited[pos - 1] = true;
            }
            for (int[] ints : q) {
                System.out.print(Arrays.toString(ints));
            }
        }
    }
}