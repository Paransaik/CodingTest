import java.util.Scanner;

public class BOJ_B3_2355_시그마 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long sum = 0;
        long max = Math.max(a, b);
        long min = Math.min(a, b) - 1;
        sum = (max * (max + 1)) / 2 - (min * (min + 1)) / 2;
        System.out.println(sum);
    }
}
