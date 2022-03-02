package Eclipse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_S5_1436_영화감독숌 {
	static int N, P, E;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int i = 0;
		for (int k = 0; k < N; i++) {
			if (Integer.toString(i).contains("666")) {
				k++;
			}
		}
		System.out.println(i - 1);
	}
}