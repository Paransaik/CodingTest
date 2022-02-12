package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_B1_2669_직사각형네개의합집합의면적구하기 {
	static int x, y, e_x, e_y, area = 0;
	static int board[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		board = new int[101][101];
		area = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			e_x = Integer.parseInt(st.nextToken());
			e_y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < e_x; j++) {
				for (int k = y; k < e_y; k++) {
					if (board[j][k] == 0) board[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (board[i][j] == 1) area++;
			}
		}
		
		bw.append(area + "\n");
		bw.flush();
	}
}