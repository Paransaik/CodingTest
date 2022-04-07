import java.util.Scanner;

public class BOJ_S4_1676_팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= a; i++) {
            if (i % 125 == 0) {
                cnt += 3;
            } else if (i % 25 == 0) {
                cnt += 2;
            } else if (i % 5 == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
