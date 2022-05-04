import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B4_2752_세수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        System.out.printf("%d %d %d", num[0], num[1], num[2]);
    }
}
