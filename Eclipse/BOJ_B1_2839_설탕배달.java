package Eclipse;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B1_2839_설탕배달 {
	static int[] arr = new int[5001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		Arrays.fill(arr, 9999);
		arr[3] = arr[5] = 1; arr[2] = 9998;
		for (int i = 6; i <= a; i++) {
			arr[i] = Math.min(arr[i - 3], arr[i - 5]) + 1;
		}
		System.out.println((arr[a] == 9999) ? -1 : arr[a]);
		System.out.println(Arrays.toString(arr));
	}
}