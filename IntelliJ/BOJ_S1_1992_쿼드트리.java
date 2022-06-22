import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_S1_1992_쿼드트리 {
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        map = new char[size][];
        for (int i = 0; i < size; i++) {
            map[i] = br.readLine().toCharArray();
        }
        recursive(0, 0, size);
        bw.flush();
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void recursive(int y, int x, int n) throws Exception {
        char chr = map[y][x];
        boolean flag = true;
        OUT:
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (map[i][j] != chr) {
                    flag = false;
                    break OUT;
                }
            }
        }
        if (flag) {
            bw.append(chr);
            return;
        }

        n /= 2;
        bw.append("(");
        recursive(y, x, n);
        recursive(y, x + n, n);
        recursive(y + n, x, n);
        recursive(y + n, x + n, n);
        bw.append(")");
    }
}
