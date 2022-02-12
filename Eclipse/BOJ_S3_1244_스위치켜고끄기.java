package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S3_1244_스위치켜고끄기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M, S, idx, gap, l, r;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			idx = Integer.parseInt(st.nextToken());

			if (S == 1) {
				for (int j = 1; j * idx <= N; j++)
					arr[j * idx - 1] ^= 1;
			} else {
				gap = 1;
				idx--;
				arr[idx] ^= 1;
				for (int j = 0; j < N / 2; j++) {
					l = idx - gap;
					r = idx + gap;

					if (l < 0 || r >= N) break;
					else if (arr[l] == arr[r]) {
						arr[l] ^= 1;
						arr[r] ^= 1;
					} else break;
					
					gap++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			bw.append(arr[i-1] + " ");
			if (i % 20 == 0) bw.append("\n");
		}
		bw.flush();
		bw.close();
	}
}