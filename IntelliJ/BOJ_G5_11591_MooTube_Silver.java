import java.io.*;
import java.util.*;

public class BOJ_G5_11591_MooTube_Silver {
    static int N, Q;
    static ArrayList<int []>[] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>(); // 정점 수 크기로 생선
        }

        int from, to, weight;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            list[to].add(new int[]{from, weight});
            list[from].add(new int[]{to, weight});
        }

        int ki, vi;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            ki = Integer.parseInt(st.nextToken());
            vi = Integer.parseInt(st.nextToken());
            bfs(ki, vi);
        }
    }

    public static void bfs(int k, int v){
        int cnt = 0;
        Queue<int []> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.offer(new int[]{v, Integer.MAX_VALUE});
        visited[v] = true;
        
        int[] node;
        while (!q.isEmpty()) {
            node = q.poll();
            for (int i = 0; i < list[node[0]].size(); i++) {
                int[] currentNode = list[node[0]].get(i);
                if (!visited[currentNode[0]]) {
                    q.offer(new int[]{currentNode[0], Math.min(currentNode[1], node[1])});
                    visited[currentNode[0]] = true;
                    if (Math.min(currentNode[1], node[1]) >= k) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
