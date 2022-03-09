import java.util.Scanner;

public class BOJ_S3_1463_1만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] b = new int[1000000];
		int a = sc.nextInt();
		for (int i = 0; i < b.length; i++) {
			b[i] = i - 1;
			if (i % 2 == 0) {
				b[i] = i / 2;
			}
			if (i % 3 == 0) {
				b[i] = i / 3;
			}
		}

//		int cnt = 0;
//		while (a != 1) {
//			if (a % 3 == 0) {
//				a /= 3;
//				cnt++;
//			} else if (a % 2 == 0) {
//				a /= 2;
//				cnt++;
//			} else {
//				a -= 1;
//				cnt++;
//			}
//		}
		System.out.println(b[a]);
	}
}
