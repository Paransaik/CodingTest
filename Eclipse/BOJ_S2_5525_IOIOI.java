package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_S2_5525_IOIOI {
	static int N, M;
	static char[] S;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine().toCharArray();
		int cnt, ans = 0;
		for (int i = 0; i < M; i++) {
			if (S[i] == 'I') {
				cnt = 0;
				while (i + 2 < M && S[i + 1] == 'O' && S[i + 2] == 'I') {
					cnt++;
					i += 2;
				}
				if (cnt >= N) ans += cnt - N + 1;
			}
		}
		bw.append(String.valueOf(ans));
		bw.flush();
	}
}
//1 ≤ N ≤ 1,000,000
//2N+1 ≤ M ≤ 1,000,000
// I OI OI OI OI CNT 4 
// -> IOIOIOI 2개 N 3
// -> IOIOI 3개 N 2
// -> IOI 4개 N 1
// M - N + 1
// N = 2
// IOIOIOIIOIIOI
// -> IOI