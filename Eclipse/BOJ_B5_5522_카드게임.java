package Eclipse;
import java.util.Scanner;

public class BOJ_B5_5522_카드게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += sc.nextInt();
		}
		System.out.println(sum);
	}

}
