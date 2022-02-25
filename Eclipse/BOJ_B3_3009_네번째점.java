import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_3009_네번째점 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int a = 0, b = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			a ^= Integer.parseInt(st.nextToken());
			b ^= Integer.parseInt(st.nextToken());
		}
		System.out.println(a + " " + b);
	}
}