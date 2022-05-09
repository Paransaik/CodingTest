import java.util.Scanner;

public class BOJ_B3_2576_홀수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            a = sc.nextInt();
            if(a % 2 == 1){
                if(min > a) min = a;
                sum += a;
            }
        }
        if(sum != 0){
            System.out.println(sum);
            System.out.println(min);
        } else System.out.println(-1);
    }
}
