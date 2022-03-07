package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S2_11724_연결요소의개수 {
	static int N, M;
	static int[] arr;
	static int[] parents;

	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[N + 1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i <= N; i++) {
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
		if (aRoot > bRoot)
			parents[aRoot] = bRoot;
		else
			parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 수

		makeSet();
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			union(from, to);
		}
		for (int i = 1; i <= N; i++) {
			findSet(i);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(i == parents[i]) cnt++;
		}
		bw.append(String.valueOf(cnt));
		bw.flush();
	}
}
