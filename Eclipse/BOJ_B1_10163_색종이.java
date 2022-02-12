package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_B1_10163_색종이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, X, Y, W, H, cnt;
	static final int boardSize = 1001;
	static int[][] board = new int[boardSize][boardSize];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			for (int x = 0; x < W; x++) {
				for (int y = 0; y < H; y++) {
					board[X + x][Y + y] = i;
				}
			}
		}

		for (int i = 1; i <= N; i++) { cnt = 0;
			for (int x = 0; x < boardSize; x++) {
				for (int y = 0; y < boardSize; y++) {
					if (board[x][y] == i) cnt++;
				}
			} bw.append(cnt + "\n");
		} bw.flush();
	}

}