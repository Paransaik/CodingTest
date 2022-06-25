import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ____BOJ_S1_2447_별찍기10 {
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(map[i], '.');

        recursive(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.append(map[i][j]);
            }
            bw.append("\n");
        }
        bw.flush();
    }

    public static void recursive(int y, int x, int n) {
        if (n == 3) {
            for (int i = 0; i < y + 3; i++) {
                for (int j = 0; j < x + 3; j++) {
                    if (i % 3 == 1 && j % 3 == 1) continue;
                    map[i][j] = '*';
                }
            }
            return;
        }

        for (int i = 0; i < y + 3; i++) {
            for (int j = 0; j < x + 3; j++) {
                if (i % 3 == 1 && j % 3 == 1) continue;
//                recursive();
            }
        }
    }
}
