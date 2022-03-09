import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int TC, A, B, aN, bN;
	static boolean[] visited;
	static Queue<Word> q;

	public static void main(String[] args) throws Exception {
		q = new LinkedList<>();
		
		StringTokenizer st;

		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			q.clear();
			visited = new boolean[10000];
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			bfs();
		}
		bw.flush();
	}

	public static void bfs() throws Exception {
		q.offer(new Word(A, ""));
		visited[A] = true;

		int n;
		while (!q.isEmpty()) {
			Word w = q.poll();

			if (w.num == B) {
				bw.append(w.path).append("\n");
				return;
			}
			n = D(w.num);
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Word(n, w.path + "D"));
			}
			n = S(w.num); // 1 - 0
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Word(n, w.path + "S"));
			}
			n = L(w.num); // 0
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Word(n, w.path + "L"));
			}
			n = R(w.num);
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Word(n, w.path + "R"));
			}
		}
	}

	public static int D(int n) {
		return (n * 2) % 10000;
	}

	public static int S(int n) {
		return (n + 9999) % 10000;
	}

	public static int L(int n) { 
		return (n % 1000) * 10 + n / 1000;
	}

	public static int R(int n) {
		return (n % 10) * 1000 + n / 10;
	}

	public static class Word {
		int num;
		String path;

		public Word(int num, String path) {
			super();
			this.num = num;
			this.path = path;
		}
	}
}
