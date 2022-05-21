import java.util.Scanner;

public class BOJ_B2_2979_트럭주차 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] time = new int[101];
        int ans = 0;
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            for (int j = s + 1; j <= e; j++) {
                time[j] += 1;
            }
        }

        for (int i = 1; i < 101; i++) {
            if(time[i] == 1) ans += time[i] * a;
            else if(time[i] == 2) ans += time[i] * b;
            else if(time[i] == 3) ans += time[i] * c;
        }
        System.out.println(ans);
    }
}
