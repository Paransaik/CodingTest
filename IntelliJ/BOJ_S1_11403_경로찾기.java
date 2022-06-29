import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S1_11403_경로찾기 {
    public static void main(String[] args) throws Exception {
        final int INF = 101;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 1) map[i][j] = INF;
            }
        }


        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                if (k == i) continue;
                for (int j = 0; j < size; j++) {
                    int cut = map[i][k] + map[k][j];
                    if (map[i][j] > cut) map[i][j] = cut;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == INF) map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        for (int[] ints : map) {
            for (int i : ints) {
                bw.append(String.valueOf(i)).append(" ");
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
