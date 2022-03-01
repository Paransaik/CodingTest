package Eclipse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_6497_전력난 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int N, E;
	static int[] parents;
	static Edge[] edgeList;

	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[N];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]); // path compression
	}

	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		while (E != 0){
			edgeList = new Edge[E];
			int sum = 0;

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				sum += weight;
				edgeList[i] = new Edge(from, to, weight);
			}

			Arrays.sort(edgeList); // 간선 비용의 오름차순 정렬
			makeSet();

			int result = 0, cnt = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					if (++cnt == N - 1)
						break;
				}
			}
			
			System.out.println(sum - result);
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
		} 
	}
}