package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_G4_2116_주사위쌓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>(6){{ //초기값 지정
		put(0, 5);
	    put(5, 0);
	    put(1, 3);
	    put(3, 1);
	    put(2, 4);
	    put(4, 2);
	}};
	
	static int N;
	static int[][] dice;
	static int[] dice_i;
	static int[] dice_sum = new int[7];
	
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<6;j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		for (int i = 0 ; i < 6; i++) {
			dice_i = new int[6];
			System.out.println(dice[0][i] + " " + hMap.get(dice[0][i]));
			System.out.println(Arrays.toString(dice[1]));
			dfs(0, dice[0][i], hMap.get(dice[0][i]));
		} 
//		System.out.println(Arrays.toString(dice_i));
	}

	public static void dfs(int level, int start, int end) {

		int max = 0;
		if (level == N) return;
		
		for (int i = 0; i < 6; i++) {
			if (i == start || i == end) continue;
			if (max < dice[level][i]) max = dice[level][i]; 
		}
		dice_i[level] = max;
		System.out.println(Arrays.toString(dice[level+1]));
		int st = Arrays.binarySearch(dice[level+1], end); // end의 위치(인덱스) 찾기, 인덱스가 s
		int en = hMap.get(st);
//		System.out.println(st + " " + en);
		dfs(level+1, st, en);
	}

}