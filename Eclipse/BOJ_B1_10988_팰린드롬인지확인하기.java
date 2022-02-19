import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B1_10988_팰린드롬인지확인하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] str;

	public static void main(String[] args) throws Exception {
		str = br.readLine().toCharArray();

		for (int i = 0; i < str.length / 2; i++) {
			if (str[i] != str[str.length - i - 1]) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
		return;
	}

}
