package Eclipse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_1753_최단경로 {

	static class Vertex implements Comparable<Vertex> {
		int no, minDistance; // 정점의 번호, 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
//		첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. 

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine()) - 1;
/*
6
0 3 5 0 0 0
0 0 2 6 0 0
0 1 0 4 6 0
0 0 0 0 2 3
3 0 0 0 0 6
0 0 0 0 0 0

output==> 12

0 ---> 1 ---> 3 ---> 5
|    ㅅ      / /  
|  /       /  /
ㅅ/       /   /
2-------/   /
\           /
 \         /
  4<-------/              
  
  \              호                  
 */
		// LinkedList로 구현
		int[][] adjMatrix = new int[V][V];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			adjMatrix[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
		}

		int[] distance = new int[V]; // 출발지에서 자신으로 오늘 최소 비용
		boolean[] visited = new boolean[V]; // 최소비용 확정 여부
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();

		Arrays.fill(distance, Integer.MAX_VALUE); // 2147483647
		distance[K] = 0; // 시작점을 0으로
		pQueue.offer(new Vertex(K, distance[K]));

		while (!pQueue.isEmpty()) {
			// ================PQ===================
			// 단계1: 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Vertex current = pQueue.poll();

			if (visited[current.no])
				continue;

			visited[current.no] = true;
//			if(current == end) break; // current가 도착지라면 끝

			// 단계2: 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소 비용을 고려
			for (int j = 0; j < V; j++) {
				// 방문하지 않았고, 인접 행렬의 값이 0이 아닐 경우
				// --> 0번부터 N노드까지의 비용이 여러 경유지를 더한 거리보다 클 경우
				if (!visited[j] && adjMatrix[current.no][j] != 0
						&& distance[j] > distance[current.no] + adjMatrix[current.no][j]) {
					// 0번부터 N노드까지의 최소 비용은 여러 경유지를 거친 거리로 갱신
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					// 큐에 삽입
					pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}
//		System.out.println(distance[end]);
		for (int dis : distance) {
			if (dis == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dis);
			}
		}

	}
}