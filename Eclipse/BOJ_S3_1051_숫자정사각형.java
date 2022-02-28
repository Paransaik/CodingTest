package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class BOJ_S3_1051_숫자정사각형 {
	static int N, M, area = 1;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < Math.min(N, M); k++) {
					if (j + k < M && i + k < N) {
						if ((arr[i][j] == arr[i + k][j]) && (arr[i][j] == arr[i][j + k])
								&& (arr[i][j] == arr[i + k][j + k])) {
							area = Math.max(area, (k + 1) * (k + 1));
						}
					}
				}
			}
		}
		bw.append(String.valueOf(area));
		bw.flush();
	}
}
