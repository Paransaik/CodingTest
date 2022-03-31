import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B2_5576_콘테스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];

        for (int i = 0; i < 10; i++) a[i] = sc.nextInt();
        for (int i = 0; i < 10; i++) b[i] = sc.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        int aSum = 0, bSum = 0;
        for (int i = 9; i > 6; i--) {
            aSum += a[i];
            bSum += b[i];
        }
        System.out.println(aSum + " " + bSum);
    }
}
