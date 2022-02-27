package Eclipse;
import java.util.Scanner;

public class BOJ_B4_15726_이칙연산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();

		System.out.println((int)Math.max(((a * b) / c), ((a / b) * c)));
	}

}