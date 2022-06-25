import java.util.Scanner;

public class BOJ_B2_24077_Comparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        int[] A = new int[a];
        int[] B = new int[b];
        for (int i = 0; i < a; i++) A[i] = sc.nextInt();
        for (int i = 0; i < b; i++) B[i] = sc.nextInt();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (A[i] <= B[j]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
