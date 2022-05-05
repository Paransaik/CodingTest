import java.util.Scanner;

public class BOJ_B4_10039_평균점수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = new int[5];
        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            if (n >= 40) {
                s[i] = n;
            } else {
                s[i] = 40;
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += s[i];
        }
        System.out.println(sum / 5);
    }
}
