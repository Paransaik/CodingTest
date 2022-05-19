import java.util.Scanner;

public class BOJ_B2_5585_거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1000 - sc.nextInt();
        int cnt = 0, sum = 0;
        if (num >= 500) {
            num -= 500;
            sum++;
        }
        if (num >= 100) {
            cnt = num / 100;
            num %= 100;
            sum += cnt;
        }
        if (num >= 50) {
            cnt = num / 50;
            num %= 50;
            sum += cnt;
        }
        if (num >= 10) {
            cnt = num / 10;
            num %= 10;
            sum += cnt;
        }
        if (num >= 5) {
            cnt = num / 5;
            num %= 5;
            sum += cnt;
        }
        if (num >= 1) {
            sum += num;
        }
        System.out.println(sum);
    }
}
