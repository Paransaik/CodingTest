import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D6_1263_D6_사람네트워크2 {
    static final int INF = 9999999;
    static int N, adjMatrix[][];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            adjMatrix = new int[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    adjMatrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && adjMatrix[i][j] == 0) {
                        adjMatrix[i][j] = INF;
                    }
                }
            }
            print();
            int ans = 0;
            for (int k = 0; k < N; ++k) {
                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < N; ++j) {
                        if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
                            adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                        }
                    }
                }
                ans = print();
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }

    private static int print() {
        int sum, ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            sum = 0;
            for (int j = 0; j < N; ++j) {
                sum += adjMatrix[i][j];
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}
