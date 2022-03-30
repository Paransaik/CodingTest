import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_3124_최소스패닝트리 {

    static int[] parents;

    public static boolean union(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if (rootA == rootB) return false;
        else if (rootA > rootB) parents[rootA] = rootB;
        else parents[rootB] = rootA;
        return true;
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static void makeSet(int a) {
        parents = new int[a + 1];
        for (int i = 1; i <= a; i++) {
            parents[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            Edge[] edgeList = new Edge[E];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from, to, cost);
            }

            makeSet(V);
            Arrays.sort(edgeList);

            long ans = 0, cnt = 0;
            for (Edge edge : edgeList) {
                if (union(edge.to, edge.from)) {
                    ans += edge.cost;
                    cnt++;
                    if (cnt == V - 1) break;
                }
            }
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }

    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

}
