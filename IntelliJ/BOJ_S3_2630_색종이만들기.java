import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2630_색종이만들기 {
    static int N, B = 0, W = 0;
    static int[][] map;

    public static boolean DnC(int y, int x, int size){
        int toggle = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != toggle){
                    DnC(y, x, size / 2);
                    DnC(y, x + size/2, size / 2);
                    DnC(y + size/2, x, size / 2);
                    DnC(y + size/2, x + size/2, size / 2);
                    return false;
                }
            }
        }
        if(toggle == 1) B++;
        else W++;
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

        DnC(0, 0, N);
        System.out.println(W);
        System.out.println(B);
    }
}
