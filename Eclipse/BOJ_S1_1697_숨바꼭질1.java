package Eclipse;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S1_1697_숨바꼭질1 {
	static int N, K, ans = Integer.MAX_VALUE;
	static final int line = 100000;
	static boolean[] visited = new boolean[line + 1];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		bfs(N);
		System.out.println(ans);
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
			visited[pos] = true;
			if (pos == K) {
				ans = Math.min(idx, ans);
			}
			if (pos <= line - 1 && !visited[pos + 1]) {
				q.offer(new int[] { pos + 1, idx + 1 });
				visited[pos + 1] = true;
			}
			if (pos <= line / 2 && !visited[pos * 2]) {
				q.offer(new int[] { pos * 2, idx + 1 });
				visited[pos * 2] = true;
			}
			if (pos > 0 && pos <= line + 1 && !visited[pos - 1]) {
				q.offer(new int[] { pos - 1, idx + 1 });
				visited[pos - 1] = true;
			}
		}
	}
}