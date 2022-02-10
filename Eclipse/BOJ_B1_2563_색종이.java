package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_B1_2563_색종이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, x, y, area;
	static int board[][];

	public static void main(String[] args) throws Exception {
		board = new int[100][100];
		N = Integer.parseInt(br.readLine());
		area = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int j = x - 1; j < x + 9; j++) {
				for (int k = y - 1; k < y + 9; k++) {
					if (board[j][k] == 0) board[j][k] = 1;
					else area++;
				}
			}
		}
		bw.append(N * 100 - area + "\n");
		bw.flush();
	}
}