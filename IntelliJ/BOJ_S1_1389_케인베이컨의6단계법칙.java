import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_1389_케인베이컨의6단계법칙 {
    static final int INF = 500001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] network = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                network[i][j] = INF;
                if (i == j) network[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            network[s][e] = network[e][s] = 1;
        }

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                for (int k = 1; k <= N; k++) {
                    if (i == k) continue;
                    int shortcut = network[i][j] + network[j][k];
                    if (network[i][k] > shortcut) network[i][k] = shortcut;
                }
            }
        }

        int min = Integer.MAX_VALUE, ans = 0;
        for (int i = 1; i <= N; i++) {
            int sum = Arrays.stream(network[i]).sum();
            if (min > sum) {
                min = sum;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
