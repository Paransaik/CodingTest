import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S2_1780_종이의개수 {
    static int[][] map;
    static int[] ans = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        recursive(0, 0, size);
        for (int an : ans) bw.append(String.valueOf(an)).append("\n");
        bw.flush();
    }

    public static boolean recursive(int y, int x, int size) {
        int toggle = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != toggle) {
                    recursive(y, x, size / 3);
                    recursive(y, x + size / 3, size / 3);
                    recursive(y, x + (size / 3) * 2, size / 3);

                    recursive(y + size / 3, x, size / 3);
                    recursive(y + size / 3, x + size / 3, size / 3);
                    recursive(y + size / 3, x + (size / 3) * 2, size / 3);

                    recursive(y + (size / 3) * 2, x, size / 3);
                    recursive(y + (size / 3) * 2, x + size / 3, size / 3);
                    recursive(y + (size / 3) * 2, x + (size / 3) * 2, size / 3);
                    return false;
                }
            }
        }
        ans[toggle + 1]++;
        return true;
    }
}