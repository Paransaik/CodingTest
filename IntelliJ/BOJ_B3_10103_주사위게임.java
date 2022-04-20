import java.util.Scanner;

public class BOJ_B3_10103_주사위게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int c = 100, d = 100;
        while (tc-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > b) d -= a;
            else if (a < b) c -= b;
        }
        System.out.println(c + "\n" + d);
    }
}
