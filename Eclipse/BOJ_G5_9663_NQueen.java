package Eclipse;
import java.util.Scanner;

public class BOJ_G5_9663_NQueen {
	static int N, ans;
	static int[] col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		col = new int[N + 1];
		setQueen(1);
		System.out.println(ans);
	}

	public static void setQueen(int rowNo) {
		if (rowNo > N) {
			ans++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			if (isAvailable(rowNo)) {
				setQueen(rowNo + 1);
			}
		}
	}

	public static boolean isAvailable(int rowNo) { // rowNo: 놓여진 마지막 퀸
		for (int i = 1; i < rowNo; i++) {
			if (col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i]))
				return false;
		}
		return true;
	}
}
