package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S3_1654_랜선자르기 {
	static int K, N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[K];
		long min = 0, max = 0;
		int stick;
		for (int i = 0; i < K; i++) {
			stick = Integer.parseInt(br.readLine());
			arr[i] = stick;
			if (stick > max)
				max = stick;
		}

		max++;
		long mid = 0;
		int cnt;
		while (min < max) {
			cnt = 0;
			mid = (min + max) / 2;

			for (int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}
			if (cnt < N) max = mid;
			else min = mid + 1;
		}
		bw.append(String.valueOf(min - 1));
		bw.flush();
	}
}