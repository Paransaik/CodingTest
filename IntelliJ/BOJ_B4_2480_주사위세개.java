import java.util.Scanner;

public class BOJ_B4_2480_주사위세개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = 0;
        if (a == b && b == c) {
            sum = a * 1000 + 10000;
        } else if (a == b) {
            sum = a * 100 + 1000;
        } else if (b == c) {
            sum = b * 100 + 1000;
        } else if (a == c){
            sum = a * 100 + 1000;
        }else {
            sum = Math.max(Math.max(a, b), c) * 100;
        }
        System.out.println(sum);
    }
}
