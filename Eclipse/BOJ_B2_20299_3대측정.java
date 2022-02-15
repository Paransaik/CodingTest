package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_B2_20299_3대측정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int TC, N, S, M, sum, cnt = 0;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sum = 0;
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] < M) {
					sum = 0;
					break;
				}
				sum += arr[i][j];		
			}
			arr[i][3] = sum;
			if (arr[i][3] >= S) {
				cnt++;
			}
		}
		bw.append(cnt + "\n");
		for (int i = 0; i < N; i++) {
			if (arr[i][3] >= S) {
				bw.append(arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}