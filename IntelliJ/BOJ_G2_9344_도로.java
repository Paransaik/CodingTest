import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_G2_9344_도로 {
    static int TC, N, M, P, Q;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;
        TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            Map<String, Integer> roads = new HashMap<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                sb = new StringBuilder();
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                sb.append(Math.min(from, to)).append(" ").append(Math.max(from, to));
                String key = sb.toString();
                roads.put(key, Math.min(roads.getOrDefault(key, weight), weight));
            }

            List<Map.Entry<String, Integer>> l = new ArrayList<>(roads.entrySet());
            l.sort(Map.Entry.comparingByValue());

            makeSet();

            boolean flag = false;
            sb = new StringBuilder();
            int min = Math.min(P, Q);
            int max = Math.max(P, Q);

            int cnt = 0;
            for (Map.Entry<String, Integer> sie : l) {
                String[] node = sie.getKey().split(" ");
                if (union(Integer.parseInt(node[0]), Integer.parseInt(node[1]))) {
                    if ((Integer.parseInt(node[0]) == min && Integer.parseInt(node[1]) == max)) {
                        flag = true;
                        break;
                    }
                    if (++cnt == N - 1) break;
                }
            }

            if (flag) bw.append("YES").append("\n");
            else bw.append("NO").append("\n");
        }

        bw.flush();
    }

    public static void makeSet() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }
}