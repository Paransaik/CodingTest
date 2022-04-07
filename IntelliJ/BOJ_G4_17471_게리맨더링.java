import java.io.*;
import java.util.*;

public class BOJ_G4_17471_게리맨더링 {
    static int N, ans;
    static int[] arrN;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 구역의 수
        arrN = new int[N + 1]; // 구역의 인구 수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        list[0] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        ans = Integer.MAX_VALUE;
        permutation(1);
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);

    }

    public static void permutation(int cnt) {
        if (cnt == N + 1) {
            if (checkRegion(true) && checkRegion(false)) {
                int aP = 0, bP = 0;
                for (int i = 1; i <= N; i++) {
                    if (visited[i]) aP += arrN[i];
                    else bP += arrN[i];
                }
                ans = Math.min(ans, Math.abs(aP - bP));
            }
            return;
        }

        visited[cnt] = true;
        permutation(cnt + 1);
        visited[cnt] = false;
        permutation(cnt + 1);
    }

    public static boolean checkRegion(boolean b) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            if (visited[i] == b) s.add(i);
        }
        if (s.size() == 0 || s.size() == N) return false;
        for (int i = 1; i <= N; i++) {
            if (s.contains(i)) {
                q.offer(i);
                s.remove(i);
                break;
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < list[node].size(); i++) {
                int to = list[node].get(i);
                if (s.contains(to)) {
                    q.offer(to);
                    s.remove(to);
                }
            }
        }
        if (s.size() != 0) return false;
        return true;
    }
}
