package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S3_1966_프린터큐 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int[] arr = new int[10];

			Queue<int[]> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			// queue에 삽입
			for (int i = 0; i < N; i++) {
				// [0] -> 가중치, [1] -> 인덱스
				int w = Integer.parseInt(st.nextToken());
				arr[w]++;
				q.offer(new int[] { w, i });
			}

			boolean flag;
			int[] node = new int[2];
			int anwser = 1;
			while (true) {
				node = q.poll();
				flag = true;
				for (int i = node[0] + 1; i < 10; i++) {
					if (arr[i] != 0) {
						q.offer(new int[] { node[0], node[1] });
						flag = false;
						break;
					}
				}
				if (flag) {
					anwser++;
					arr[node[0]]--;
					if (node[1] == M) {
						break;
					}
				}

			}
			bw.append(anwser - 1 + "\n");
		}
		bw.flush();
	}
}
