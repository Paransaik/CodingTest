import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S4_10994_별찍기19 {
    static char[][] map;
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        size = (n - 1) * 4 + 1;
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(map[i], ' ');
        }
        recursive(0, 0, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bw.append(map[i][j]);
            }
            bw.append("\n");
        }
        bw.flush();
    }

    public static void recursive(int y, int x, int n) {
        if (n < 0) return;
        for (int i = x; i <= size - x - 1; i++) {
            map[y][i] = '*';
            map[size - y - 1][i] = '*';
        }
        for (int i = y + 1; i <= size - y - 1; i++) {
            map[i][x] = '*';
            map[i][size - x - 1] = '*';
        }
        recursive(y + 2, x + 2, n - 4);
    }
}
