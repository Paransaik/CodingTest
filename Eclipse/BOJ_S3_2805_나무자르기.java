package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S3_2805_나무자르기 {
	static int N, M;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		long min = 0, max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if (arr[i] > max) max = arr[i];
		}

		max++;
		long mid = 0;
		long treeSum;
		while (min < max) {
			treeSum = 0;
			mid = (min + max) / 2;
			for (int i = 0; i < N; i++) {
				if ( arr[i] - mid >= 0) treeSum += arr[i] - mid;
			}
			System.out.println(min + " " + max + " " + treeSum);
			if (treeSum < M) max = mid;
			else min = mid + 1;
			
		}
		bw.append(String.valueOf(min - 1));
		bw.flush();
	}
}