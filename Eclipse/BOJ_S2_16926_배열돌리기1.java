package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S2_16926_배열돌리기1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int[][] arr, copy_arr;
	static int N, M, R;
	static int x, y, nx, ny, temp, direction;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int cir = Math.min(N, M)/2;
		for (int i = 0; i < cir; i++) {
			x = i; y = i;
			for (int r = 0; r < R; r++) {
				direction = 0;
				temp = arr[i][i];
				while (direction < 4) {
					nx = x + dx[direction];
					ny = y + dy[direction];
					if (nx >= M-i || nx < 0+i || ny >= N-i || ny < 0+i) {
						direction++;
						continue;
					}
					arr[y][x] = arr[ny][nx];
					x = nx; y = ny;
				}
				arr[i+1][i] = temp;
			}
		}
		for (int[] is : arr) {
			for (int i : is) bw.append(i + " "); bw.append("\n");
		}
		bw.flush();
	}
}
