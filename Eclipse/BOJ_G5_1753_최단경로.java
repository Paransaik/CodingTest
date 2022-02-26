package Eclipse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_1753_최단경로 {

	static class Vertex implements Comparable<Vertex> {
		int no, weight; // 정점의 번호, 출발지에서 자신으로의 최소비용

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

//		첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. 
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine()) - 1;

		ArrayList<Vertex>[] list = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<>(); // 정점 수 크기로 생선
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			list[Integer.parseInt(st.nextToken()) - 1]
					.add(new Vertex(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
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
			// current = start, distatnce[start] --> 시작점부터 목표까지의 거리 가중치
			if (visited[current.no]) continue;
 
			visited[current.no] = true;
//			if(current == end) break; // current가 도착지라면 끝

			// 단계2: 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			int dest, cost;
			for (int j = 0; j < list[current.no].size(); j++) {
				dest = list[current.no].get(j).no; 
				cost = list[current.no].get(j).weight;
				if (distance[dest] > distance[current.no] + cost) {
					distance[dest] = distance[current.no] + cost;
					pQueue.offer(new Vertex(dest, distance[dest]));
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