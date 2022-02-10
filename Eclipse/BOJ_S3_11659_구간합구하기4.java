package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S3_11659_구간합구하기4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M, x, y;
	static int[] nums, prefixSum;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		prefixSum = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		nums[0] = prefixSum[1] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			bw.append(prefixSum[y] - prefixSum[x-1] + "\n");
		}
		bw.flush();
	}
}