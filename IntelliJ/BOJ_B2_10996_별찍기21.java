import java.util.Scanner;

public class BOJ_B2_10996_별찍기21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (n % 2 == 0) {
                for (int k = 0; k < n / 2; k++) {
                    System.out.print("* ");
                }
                System.out.println();
                for (int k = 0; k < n / 2; k++) {
                    System.out.print(" *");
                }
                System.out.println();
            } else {
                for (int k = 0; k < n / 2 + 1; k++) {
                    System.out.print("* ");
                }
                System.out.println();
                for (int k = 0; k < n / 2; k++) {
                    System.out.print(" *");
                }
                System.out.println();
            }
        }
    }
}
