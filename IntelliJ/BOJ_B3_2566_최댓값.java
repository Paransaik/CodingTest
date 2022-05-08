import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_2566_최댓값 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[9][9];
        int max = Integer.MIN_VALUE;
        int y = 0, x = 0, num;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num >= max) {
                    max = num;
                    y = i;
                    x = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((y + 1) + " " + (x + 1));
    }
}
