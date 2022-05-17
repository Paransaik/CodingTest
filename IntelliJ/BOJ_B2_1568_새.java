import java.util.Scanner;

public class BOJ_B2_1568_새 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int cnt = 1, time = 0;
        while (a > 0) {
            if(a - cnt >= 0) {
                a -= cnt;
                cnt++;
                time++;
            } else {
                cnt = 1;
            }
        }
        System.out.println(time);
    }
}
