import java.util.Scanner;

public class BOJ_B1_2163_초콜릿자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(r - 1 + (r * (c - 1)));
    }
}
