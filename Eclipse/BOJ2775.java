package Eclipse;

// BOJ 2775
import java.util.Scanner;

public class BOJ2775 {
	static int T;
	static int k, n;
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			k = sc.nextInt();
			n = sc.nextInt();
			board = new int[k + 1][n];

			for (int j = 0; j < n; j++) {
				board[0][j] = j + 1;
			}
			for (int y = 1; y < k+1; y++) {
				for (int x = 0; x < n; x++) {
					if (x == 0)
						board[y][x] = board[y - 1][x];
					else
						board[y][x] = board[y][x - 1] + board[y - 1][x];
				}
			}
			System.out.println(board[k][n-1]);
		}
	}
}