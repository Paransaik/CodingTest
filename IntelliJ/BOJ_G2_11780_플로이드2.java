import java.io.*;
import java.util.*;

public class BOJ_G2_11780_플로이드2 {
    static int N;
    static final int INF = 10000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        List<Integer>[] l = new LinkedList[N * N];
        for (int i = 0; i < N * N; i++) l[i] = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int idx = i * N + j;
                l[idx].add(i);
                l[idx].add(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    map[i][j] = INF;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            if (map[from][to] == INF) map[from][to] = weight;
            else map[from][to] = Math.min(map[from][to], weight);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cut = map[i][k] + map[k][j];
                    if (map[i][j] > cut) {
                        map[i][j] = cut;
                        int idx = i * N + j;
                        l[idx].clear();
                        l[idx].add(i);
                        l[idx].add(j);
                        l[idx].addAll(l[idx].size() - 1, l[i * N + k].subList(1, l[i * N + k].size()));
                        l[idx].addAll(l[idx].size() - 1, l[k * N + j].subList(1, l[k * N + j].size() - 1));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == INF) bw.append("0 ");
                else bw.append(String.valueOf(map[i][j])).append(" ");
            }
            bw.append("\n");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || map[i][j] == INF) {
                    bw.append("0");
                } else {
                    int idx = i * N + j;
                    bw.append(String.valueOf(l[idx].size())).append(" ");
                    for (Integer integer : l[idx]) {
                        bw.append(String.valueOf(integer + 1)).append(" ");
                    }
                }
                bw.append("\n");
            }
        }
        bw.flush();
    }
}