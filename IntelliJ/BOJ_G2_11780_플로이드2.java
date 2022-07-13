import java.io.*;
import java.util.*;

public class BOJ_G2_11780_플로이드2 {
    static int N;
    static final int INF = 10000001;
    static boolean[] visited;
    static List<Integer> visitedList;
    static HashMap<Integer, Integer>[] m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        m = new HashMap[N];
        for (int i = 0; i < N; i++) m[i] = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    map[i][j] = INF;
                } else {
                    m[i].put(i, 0);
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

            if (map[from][to] == INF) {
                map[from][to] = weight;
                m[from].put(to, weight);
            } else {
                m[from].remove(to);
                int minWeight = Math.min(map[from][to], weight);
                map[from][to] = minWeight;
                m[from].put(to, minWeight);
            }
        }

        for (HashMap<Integer, Integer> integerIntegerHashMap : m) {
            for (Map.Entry<Integer, Integer> integerIntegerEntry : integerIntegerHashMap.entrySet()) {
                System.out.print("[" + integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue() + "]");
            }
            System.out.println();
        }

        // 워샬
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cut = map[i][k] + map[k][j];
                    if (map[i][j] > cut) {
                        map[i][j] = cut;
                    }
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == INF) bw.append("0 ");
                else bw.append(String.valueOf(map[i][j])).append(" ");
            }
            bw.append("\n");
        }

        visitedList = new LinkedList<>();
        visited = new boolean[N];
        visitedList.clear();
        dfs(0, 1);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (i == j) bw.append("0").append("\n");
//                visited = new boolean[N];
//                visitedList.clear();
//                dfs(i, j);
//            }
//        }
        bw.flush();
    }

    public static void dfs(int s, int e) {
        if (s == e) return;
        visited[s] = true;
        for (int i = 0, len = m[s].size(); i < len; i++) {
            if (!visited[m[s].getOrDefault(i, s + 1)]) {
                dfs(m[s].get(i), e);
                visitedList.add(m[s].get(i) + 1);
            }
        }
    }
}