package Eclipse;
import java.util.Scanner;

public class BOJ_B3_5717_상근이의친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		while(true) {
			x = sc.nextInt();
			y = sc.nextInt();
			if(x == 0) return;
			System.out.println(x+y);
		}
	}
}
