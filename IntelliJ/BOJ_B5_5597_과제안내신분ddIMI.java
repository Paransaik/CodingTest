import java.util.Scanner;

public class BOJ_B5_5597_과제안내신분ddIMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] student = new boolean[31];
        for (int i = 0; i < 28; i++) {
            student[sc.nextInt()] = true;
        }
        for (int i = 1; i < 31; i++) {
            if (!student[i]) System.out.println(i);
        }
    }
}