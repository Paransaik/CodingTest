import java.util.Scanner;

public class BOJ_B4_5596_시험점수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = 0, G = 0;
        for (int j = 0; j < 4; j++) S += sc.nextInt();
        for (int j = 0; j < 4; j++) G += sc.nextInt();
        System.out.println(S > G ? S : G);
    }
}
