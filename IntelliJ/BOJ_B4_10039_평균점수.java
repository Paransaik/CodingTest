import java.util.Scanner;

public class BOJ_B4_10039_평균점수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            if (n >= 40) sum += n;
            else sum += 40;
        }
        System.out.println(sum / 5);
    }
}
