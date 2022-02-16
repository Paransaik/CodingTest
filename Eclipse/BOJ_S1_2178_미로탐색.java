package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_S1_2178_미로탐색 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M, p1, p2;

	static Queue<int[]> q = new LinkedList<>();
	static int[][] board;
	static int[] coor;
	static String line;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][];

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			board[i] = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
		}
		bfs(0, 0);
		

	}

	public static int bfs(int x, int y) {
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			coor = q.poll();
			p1 = coor[0];
			p2 = coor[1];

			for (int i = 0; i < 4; i++) {
				int nx = p1 + dx[i];
				int ny = p2 + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 0)
					continue;

				if (board[nx][ny] == 1) {
					q.offer(new int[] { nx, ny });
					board[nx][ny] = board[p1][p2] + 1;
				}
			}
		}
		return board[N - 1][M - 1];
	}
}
