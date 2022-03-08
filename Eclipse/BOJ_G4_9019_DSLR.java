package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_9019_DSLR {
	static int TC, A, B, aN, bN;
	static boolean[] visited;
	static Queue<Word> q;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			q.clear();
			visited = new boolean[10000];
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			bw.append(bfs()).append("\n");
		}
		bw.flush();
	}

	public static String bfs() {
		q.offer(new Word(A, ""));
		visited[A] = true;

		int n;
		while (!q.isEmpty()) {
			Word w = q.poll();

			if (w.num == B) {
				return w.path;
			}
			n = D(w.num);
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Word(n, w.path + "D"));
			}
			n = S(w.num);
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Word(n, w.path + "S"));
			}
			n = L(w.num);
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
		return "";
	}

	public static int D(int n) {
		return (n * 2) % 10000;
	}

	public static int S(int n) {
		return (n + 9999) % 10000;
	}

	public static int L(int n) {
		if (n == 0) return 0;
		int len = 0, w = n;
		while (w != 0) {
			w /= 10;
			len++;
		}
		if (len < 4) return n * 10;
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
