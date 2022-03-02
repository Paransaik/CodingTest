package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S3_11047_동전 {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 동전 개수
		K = Integer.parseInt(st.nextToken()); // 원
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0, idx = N-1;
		while (K != 0) {
			if(arr[idx] <= K) {
//				System.out.println(K);
				K -= arr[idx];
				cnt++;	
			} else {
				idx--;
			}
		}
		bw.append(cnt + "\n");
		bw.flush();
	}
}
