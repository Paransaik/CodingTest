import java.io.*;
import java.util.*;

public class BOJ_G2_4195_친구네트워크 {
    static int[] parents;

    public static int findSet(int a) {
        if (parents[a] < 0) {
            return a;
        }
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        else if (parents[aRoot] > parents[bRoot]) {
            parents[bRoot] += parents[aRoot];
            parents[aRoot] = bRoot;
        } else {
            parents[aRoot] += parents[bRoot];
            parents[bRoot] = aRoot;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Map<String, Integer> m = new HashMap<>();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            m.clear();
            int ps = 0;

            int N = Integer.parseInt(br.readLine());
            parents = new int[N * 2 + 1];
            for (int i = 1; i < N * 2 + 1; i++) {
                parents[i] = -1;
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if (!m.containsKey(p1)) m.put(p1, ++ps);
                if (!m.containsKey(p2)) m.put(p2, ++ps);
                union(m.get(p1), m.get(p2));
                bw.append(String.valueOf(parents[findSet(m.get(p1))] * -1)).append("\n");

            }
        }
        bw.flush();
    }
}