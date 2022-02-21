package Eclipse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2961_도영이가만든맛있는음식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, min = Integer.MAX_VALUE;
	static int[][] s;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		s = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s[i][0] = Integer.parseInt(st.nextToken());
			s[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < 1 << N; i++) {
			int a = 1, b = 0;
			for(int j = 0; j < N; j++) {
				if((i & 1 << j) > 0 ) {
					a *= s[j][0];
					b += s[j][1];
				}
			}
			min = Math.min(Math.abs(a-b), min);
		}
		System.out.println(min);
	}
	
}