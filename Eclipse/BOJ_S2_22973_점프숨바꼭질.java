package Eclipse;
import java.util.Scanner;

public class BOJ_S2_22973_점프숨바꼭질 {
	static long K;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		K = Math.abs(sc.nextLong());
		System.out.println((K == 0) ? 0 : (K % 2 != 0) ? Long.toBinaryString(K).length() : -1);
	}
}