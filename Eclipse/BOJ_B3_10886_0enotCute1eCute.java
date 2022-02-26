package Eclipse;
import java.util.Scanner;

public class BOJ_B3_10886_0enotCute1eCute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int zCnt = 0, oCnt = 0;
		for (int i = 0; i < a; i++) {
			int b = sc.nextInt();
			if (b == 0) {
				zCnt++;
			} else {
				oCnt++;
			}
		}
		if (zCnt > oCnt) {
			System.out.println("Junhee is not cute!");
		} else {
			System.out.println("Junhee is cute!");
		}
	}

}
