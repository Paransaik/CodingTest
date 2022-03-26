import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ____BOJ_S3_2630_색종이만들기 {
    static int N, cnt;
    static int[][] map;

    public static boolean DnC(int y, int x, int size){
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][y] == 0){
                    DnC(y, x, size / 2);
                    DnC(y, x + size/2, size / 2);
                    DnC(y + size/2, x, size / 2);
                    DnC(y + size/2, x + size/2, size / 2);
                    return false;
                }
            }
        }
        cnt++;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map));
        }
        DnC(0, 0, N);
        System.out.println(cnt);
    }
}
