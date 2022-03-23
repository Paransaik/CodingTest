import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ____BOJ_S1_2527_직사각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int X, Y, N, sum = 0;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());

			bw.flush();
			bw.close();
		}
	}
}