package Eclipse;
import java.io.*;
import java.util.*;

public class BOJ_G4_1715_카드정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, cnt = 0, sum = 0;
	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}
		while(q.size() > 1) {
			cnt = q.poll() + q.poll();
			sum += cnt;
			q.offer(cnt);
		}
		System.out.println(sum);
	}
}
