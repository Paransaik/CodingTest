import java.util.Scanner;

public class BOJ_S5_13015_별찍기23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 상단
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < n * 2 - 3; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        // 중단
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < n - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < (n - i - 1) * 2 - 3; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < n - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
        for (int j = 0; j < n - 2; j++) {
            System.out.print(" ");
        }
        System.out.print("*");
        for (int j = 0; j < n - 2; j++) {
            System.out.print(" ");
        }
        System.out.println("*");

        for (int i = n - 3; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < n - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j <= (n - 2 - i) * 2 - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < n - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        // 하단
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < n * 2 - 3; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }
}
