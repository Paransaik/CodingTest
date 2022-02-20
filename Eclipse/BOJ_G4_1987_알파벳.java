package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_G4_1987_알파벳 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int R, C;

	static char[][] map;
	static boolean[] visited;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int max = 0;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[26];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1);
		bw.append(String.valueOf(max));
		bw.flush();
	}

	public static void dfs(int y, int x, int idx) {
		visited[map[y][x] - 'A'] = true;
		max = Math.max(max, idx);
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
			if (visited[map[ny][nx] - 'A']) continue;
			dfs(ny, nx, idx + 1);
		}
		visited[map[y][x] - 'A'] = false;
	}
}