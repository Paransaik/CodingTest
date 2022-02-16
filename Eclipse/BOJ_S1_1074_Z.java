package Eclipse;
import java.util.*;
public class BOJ_S1_1074_Z {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int X = s.nextInt();
		int Y = s.nextInt();
		System.out.println(z(X, Y, N));
	}
	public static int z(int x, int y, int w) {
		if (w == 0) return 0;
		return 2 * (x % 2) + (y % 2) + 4 * z(x / 2, y / 2, w - 1);
	}
}