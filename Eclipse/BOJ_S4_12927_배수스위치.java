package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_S4_12927_배수스위치 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int[] arr;
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] digits = sc.nextLine().toCharArray();
		
		for (int i = 1; i <= digits.length; i++) {
			if (digits[i - 1] == 'N') continue;
			cnt++;
			for (int j = 1; j * i <= digits.length; j++) digits[j * i - 1] ^= 23;
		}
		System.out.println(cnt);
//		bw.append(cnt + "\n");
//		bw.flush();
//		bw.close();
//		int[] digits = Stream.of(br.readLine().replace("Y", "1").replace("N", "0").split(""))
//				.mapToInt(Integer::parseInt).toArray();
//		
//		for (int i = 1; i <= digits.length; i++) {
//			if (digits[i - 1] == 0) continue; cnt++;
//			for (int j = 1; j * i <= digits.length; j++) digits[j * i -1] ^= 1;
//		}
//		bw.append(cnt + "\n");
//		bw.flush();
//		bw.close();
	}
}