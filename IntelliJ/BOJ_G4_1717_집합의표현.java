import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G4_1717_집합의표현 {
    static int N, M;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        if (aRoot > bRoot) parents[aRoot] = bRoot;
        else parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        makeSet();

        int oper, to, from;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            oper = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            if (oper == 0) union(to, from);
            else {
                if (findSet(to) == findSet(from)) bw.append("YES").append("\n");
                else bw.append("NO").append("\n");
            }
        }
        bw.flush();
    }
}