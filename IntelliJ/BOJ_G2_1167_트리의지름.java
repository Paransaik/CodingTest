import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_G2_1167_트리의지름 {
    static LinkedList<int[]>[] l;
    static boolean[] visited;
    static int lastVotex = 1;
    static int maxWeight = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine());
        l = new LinkedList[v + 1];
        for (int i = 0; i < v + 1; i++) l[i] = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                if (from == -1){ break;}
                int weight = Integer.parseInt(st.nextToken());
                l[to].add(new int[]{from, weight});
            }
        }

        visited = new boolean[v + 1];
        dfs(1, 0);
        visited = new boolean[v + 1];
        dfs(lastVotex, 0);
        System.out.println(maxWeight);
    }

    public static void dfs(int s, int w) {
        visited[s] = true;
        for (int[] ints : l[s]) {
            if (!visited[ints[0]]) {
                int addWeight = w + ints[1];
                if (addWeight > maxWeight) {
                    lastVotex = ints[0];
                    maxWeight = addWeight;
                }
                dfs(ints[0], addWeight);
            }
        }
        visited[s] = false;
    }
}
