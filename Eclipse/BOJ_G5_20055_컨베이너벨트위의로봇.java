package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_G5_20055_컨베이너벨트위의로봇 {
	static int N, K;
	static int init = 0, cnt, step = 0;
	static Deque<Belt> q = new ArrayDeque<>(); // 내구도, 로봇 유무
	static Belt b;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int durability;
		for (int i = 0; i < 2 * N; i++) {
			durability = Integer.parseInt(st.nextToken());
			if (durability == 0) init++;
			q.offer(new Belt(durability, false));
		}
		
		while (init + cnt < K) {
			cnt = 0;
			first();
			second();
			three();
			four();
			step++;
		}
		bw.append(String.valueOf(step));
		bw.flush();
	}

	// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
	static void first() {
		// 1 2 3 4 5 6
		for (int i = 0; i < N - 2; i++) {
			q.addLast(q.poll());
		}
		// 2 3 4 5 6 1
		q.peek().robot = false;
		for (int i = 0; i < N - 1; i++) {
			q.addFirst(q.pollLast());
		}
		// 6 1 2 3 4 5
	}

	// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히
	// 있는다. (로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.)
	static void second() {
		// 6 1 2 3 4 5
		for (int i = 0; i < N; i++) {
			q.addLast(q.poll());
		}
		// 3 4 5 6 1 2
		b = q.pollLast(); // 2
		for (int i = 0; i < N - 1; i++) {
			Belt DyB = q.pollLast(); // 1
			if(DyB.robot == true && b.robot != true && b.durability != 0) {
				b.durability--;
				b.robot = DyB.robot;
				DyB.robot = false;
			}
			q.addFirst(b);
			b = DyB; // <<
		}
		q.addFirst(b);
		
		// 1 2 3 4 5 6
		for (int i = 0; i < N - 1; i++) {
			q.addLast(q.poll());
		}
		// 3 4 5 6 1 2
		q.peek().robot = false;
		for (int i = 0; i < N - 1; i++) {
			q.addFirst(q.pollLast());
		}
		// 6 1 2 3 4 5
	}

	// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
	static void three() {
		if (q.peekFirst().durability != 0) {
			b = q.poll();
			--b.durability;
			b.robot = true;
			q.addFirst(b);
		}
	}

	// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
	static void four() {
		for (Belt belt : q) {
			if (belt.durability == 0) cnt++;
		}
	}

	public static class Belt {
		int durability;
		boolean robot;

		public Belt(int durability, boolean robot) {
			super();
			this.durability = durability;
			this.robot = robot;
		}
		@Override
		public String toString() {
			return "[dur=" + durability + ", rob=" + robot + "]";
		}
	}
}
