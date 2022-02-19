package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S1_2564_경비원 {
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
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N + 1; i++) {
			switch (arr[i][0]) {
			case 1: arr[i][0] = arr[i][1]; break;
			case 2: arr[i][0] = (2 * X) + Y - arr[i][1]; break;
			case 3: arr[i][0] = 2 * (X + Y) - arr[i][1]; break;
			case 4: arr[i][0] = X + arr[i][1]; break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			sum += Math.min(
					Math.abs(arr[N][0] - arr[i][0]), 
					2 * (X + Y) - Math.abs(arr[N][0] - arr[i][0]));
		}
		
		bw.append(String.valueOf(sum));
		bw.flush();
		bw.close();
	}

}