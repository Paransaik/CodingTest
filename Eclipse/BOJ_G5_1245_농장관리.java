package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_1245_농장관리 {
	static int N, M, sum = 0;
	static int[][] map;

	static int[] dx = { 0, 0, -1, -1, -1, 1, 1, 1 };
	static int[] dy = { -1, 1, -1, 1, 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (!mapIsEmpty()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
					}
				}
			}
			cutMountain();
		}
		System.out.println(sum);

	}

	public static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { y, x });
		map[y][x] = 0;

		int[] peaks;
		int flag = 0;
		while (!q.isEmpty()) {
			peaks = q.poll();
			for (int i = 0; i < 8; i++) {
				int ny = peaks[0] + dy[i];
				int nx = peaks[1] + dx[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if (map[ny][nx] > 1) flag = 1;
				if (map[ny][nx] == 1) {
					q.offer(new int[] { ny, nx });
					map[ny][nx] = 0;
				}
			}
		}
		if (flag == 0) sum++;
	}

	public static void cutMountain() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) map[i][j] -= 1;
			}
		}
	}
	
	public static boolean mapIsEmpty() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) return false;
			}
		}
		return true;
	}
}
