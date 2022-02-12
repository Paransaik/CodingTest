import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_G4_2116_주사위쌓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>(6) {
		{ // 초기값 지정
			put(0, 5);
			put(5, 0);
			put(1, 3);
			put(3, 1);
			put(2, 4);
			put(4, 2);
		}
	};

	static int N, sum;
	static int[][] dice;
	static int[] dice_sum = new int[6];

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 6; i++) {
			sum = 0;
			dfs(0, dice[0][i]);
			dice_sum[i] = sum;
		}
		
		Arrays.sort(dice_sum);
//		System.out.println(Arrays.toString(dice_sum));
		bw.append(dice_sum[5] + "\n");
		bw.flush();
	}

	// 2 3 1 6 5 4
	public static void dfs(int level, int start) { // start: 2(value)를 넘김

		int max = 0;
		if (level == N)
			return;
		
		int start_idx = IntStream.range(0, dice[level].length).
				        filter(i -> start == dice[level][i]).
				        findFirst().orElse(-1);
		
		int end_idx = IntStream.range(0, dice[level].length).
				        filter(i -> dice[level][hMap.get(start_idx)] == dice[level][i]).
				        findFirst().orElse(-1);
		
//		System.out.println("start: " + start_idx + "end: " + end_idx);
		// level 의 옆면 중 최댓값 구하기
		for (int i = 0; i < 6; i++) {
			if (i == start_idx || i == end_idx)
				continue;
			if (max < dice[level][i])
				max = dice[level][i];
		}

		sum += max; // 최댓값 dice_i에 갱신
//		System.out.println("max: " + max);
		dfs(level + 1, dice[level][end_idx]);
	}

}