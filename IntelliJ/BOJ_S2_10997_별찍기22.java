import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S2_10997_별찍기22 {
    static char[][] map;
    static int size;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) System.out.println("*");
        else {
            size = (n - 1) * 4 + 1;
            map = new char[size + 2][size];
            for (int i = 0; i < size + 2; i++) {
                Arrays.fill(map[i], ' ');
            }

            int d = 0;
            int y = 0, x = size;
            while (y != (size + 2) / 2 + 1 || x != size / 2) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                int nty = y + dy[d] * 2;
                int ntx = x + dx[d] * 2;

                if (ny < 0 || ny >= size + 2 || nx < 0 || nx >= size ||
                        ((nty >= 0 && nty < size + 2 && ntx >= 0 && ntx < size) && map[nty][ntx] == '*')) {
                    d = (d + 1) % 4;
                    continue;
                }

                map[ny][nx] = '*';

                y = ny;
                x = nx;
            }

            for (int i = 0; i < size + 2; i++) {
                for (int j = 0; j < size; j++) {
                    if(i == 1 && map[i][j] != '*') continue;
                    bw.append(map[i][j]);
                }
                bw.append("\n");
            }
            bw.flush();
        }
    }
}
