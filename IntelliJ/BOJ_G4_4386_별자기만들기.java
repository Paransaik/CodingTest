import java.io.*;
import java.util.*;

public class BOJ_G4_4386_별자기만들기 {
    static int N;
    static int[] parents;
    static double[][] stars;

    public static double dotTodot(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void makeSet() {
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        makeSet();
        stars = new double[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        List<Node> l = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                l.add(new Node(i, j, dotTodot(stars[i][0], stars[j][0], stars[i][1], stars[j][1])));
            }
        }
        Collections.sort(l, Comparator.comparingDouble(n -> n.weight));
        int cnt = 0;
        double result = 0;
        for (Node node : l) {
            if(union(node.from, node.to)){
                result += node.weight;
                if(++cnt == N - 1) break;
            }
        }
        bw.append(String.valueOf(result));
        bw.flush();
    }

    static class Node {
        int from;
        int to;
        double weight;

        public Node(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
