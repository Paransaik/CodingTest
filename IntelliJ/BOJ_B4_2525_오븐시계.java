import java.util.Scanner;

public class BOJ_B4_2525_오븐시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int work = sc.nextInt();
        int time = h * 60 + m + work;
        time %= (24 * 60);
        h = time / 60;
        m = time % 60;
        System.out.println(h + " " + m);
    }
}
