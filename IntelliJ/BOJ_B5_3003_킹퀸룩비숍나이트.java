import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_B5_3003_킹퀸룩비숍나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int[] ans = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
            System.out.print((ans[i] - Integer.parseInt(st.nextToken())) + " ");
        }
    }
}
