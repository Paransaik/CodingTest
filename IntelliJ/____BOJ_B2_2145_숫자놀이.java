import java.util.Scanner;

public class ____BOJ_B2_2145_숫자놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            if (a == 0) break;
            int num = Integer.MAX_VALUE;
            while (num > 10) {
                num = 0;
                while (a > 10) {
                    num += a % 10;
                    a /= 10;
                }
                a = num;
            }
            System.out.println(a);
        }
    }
}
