import java.util.Scanner;

public class BOJ_B4_10768_특별한날 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if( a == 2){
            if (b == 18) {
                System.out.println("Special");
                return;
            } else if (b > 18) {
                System.out.println("After");
            } else {
                System.out.println("Before");
            }
        } else if (a > 2) {
            System.out.println("After");
            return;
        } else if ( a < 2){
            System.out.println("Before");
            return;
        }
    }
}
