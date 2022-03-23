import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ____BOJ_S4_2477_참외밭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;

	static int K, d, distance;
	static int[][] disArr;

	public static void main(String[] args) throws Exception {
		K = Integer.parseInt(br.readLine());
		disArr = new int[6][2];

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				disArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Arrays.deepToString(disArr));
	}

}
