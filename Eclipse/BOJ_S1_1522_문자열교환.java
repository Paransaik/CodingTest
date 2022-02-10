package Eclipse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_1522_문자열교환 {
	static int answer, len, aCnt, bCnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] line = br.readLine().split("");
		len = answer = line.length;
		aCnt = 0;
		
		for (String s : line) if (s.equals("a")) aCnt++;
		
		for (int j = 0; j < len * 2; j++) { bCnt = 0;
			for (int k = j; k < j + aCnt; k++) {
				if (line[k % len].equals("b")) bCnt++;
			}
			answer = Math.min(answer, bCnt);
		}
		System.out.println(answer);
	}
}