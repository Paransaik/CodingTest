package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_20304_비밀번호제작 {
	static int TC, N, M, cnt, answer;
	static boolean flag;
	static char[] bi;
	static int[] arr, q;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Queue<int[]> queue = new LinkedList<>();
		// 관리자의 패스워드는 0이상 N이하의 범위 정수
		// 이진법으로 표현 해야 됨
		N = Integer.parseInt(br.readLine()); // 관리자의 패스워드 최댓값
		M = Integer.parseInt(br.readLine()); // 해커가 사용한 패스워드 개수

		isSelected = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) { // 해커가 사용한 패스워드 arr에 삽입
			int qo = Integer.parseInt(st.nextToken());
			queue.offer(new int[] { 0, qo });
			isSelected[qo] = true;
		}

		while (!queue.isEmpty()) {
			q = queue.poll(); // q[0]: idx, q[1]: int

			for (int i = 0; i < 20; i++) {
				int que = q[1] ^ (int) Math.pow(2, i); // 해당 수와 1차이나는 경우의 수 xor 연산
					
				if (que > N) continue; // 10보다 작을경우만 queue에 넣음
				if (isSelected[que]) continue; // 방문한 적이 있는 노드일 경우 skip

				isSelected[que] = true;

				queue.offer(new int[] { q[0] + 1, que }); // idx+1 와 해당 수 push
				answer = Math.max(q[0] + 1, answer); // max값 갱신
			}
		}
		System.out.println(answer);

		bw.flush(); // 출력
		bw.close(); // 자원 해제
	}
}