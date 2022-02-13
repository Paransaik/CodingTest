package Eclipse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_G4_2116_주사위쌓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, sum, sumMax = 0;
	static int[][] dice;
	static int[] hMap = {5, 3, 4, 1, 2, 0};
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) dice[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 6; i++) { sum = 0;
			sumMax = Math.max(sumMax, dfs(0, dice[0][i]));
		}
		bw.append(sumMax + "\n");
		bw.flush();
	}

	// 2 3 1 6 5 4
	public static int dfs(int level, int start) {
		if (level == N) return sum;
		int max = 0, s_idx = -1, e_idx = -1;
		for (int i = 0; i < 6; i++) if (dice[level][i] == start) s_idx = i;
		for (int i = 0; i < 6; i++) if (dice[level][i] == dice[level][hMap[s_idx]]) e_idx = i;
		
		for (int i = 0; i < 6; i++) {
			if (i != s_idx && i != e_idx) max = max < dice[level][i]? dice[level][i]: max;
		}
		sum += max;
		return dfs(level + 1, dice[level][e_idx]);
	}
}