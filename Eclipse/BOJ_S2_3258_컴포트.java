package Eclipse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S2_3258_컴포트 {
	static int N, Z, M;
	static int[] M_cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // field 개수
		Z = Integer.parseInt(st.nextToken()); // end point
		M = Integer.parseInt(st.nextToken()); // 장애물 개수

		M_cnt = new int[M];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			M_cnt[i] = Integer.parseInt(st.nextToken());
		}

		int target_point, flag;
		for (int answer = 1; answer <= Z; answer++) {
			flag = 0;
			target_point = 1;
			for(int j = 0; j <= N; j++) {
				target_point = (target_point + answer) % N;
				if (target_point == 0) target_point = N;
				for (int k = 0; k < M; k++) {
					if (target_point == M_cnt[k]) {
						flag = 1;
						break;
					}
				}
				if (target_point == Z) {
					System.out.println(answer);
					flag = 2;
					break;
				}
				if (flag == 1) break;
			}
			if (flag == 2) break;
		}
	}
}
