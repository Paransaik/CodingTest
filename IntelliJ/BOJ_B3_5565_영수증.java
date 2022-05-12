import java.util.Scanner;

public class BOJ_B3_5565_영수증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        for (int i = 0; i < 9; i++) {
            sum -= sc.nextInt();
        }
        System.out.println(sum);
    }
}
