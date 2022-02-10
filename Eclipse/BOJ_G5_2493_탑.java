package Eclipse;

//BOJ2439
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G5_2493_탑 {
	static int N;
	static int[] arr, answer;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Stack<int[]> stack = new Stack<>();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		answer = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			while (!stack.empty()) {
				if (stack.peek()[1] > arr[i]) {
					answer[i] = stack.peek()[0] + 1;
					break;
				} else stack.pop();
			} stack.push(new int[] { i, arr[i] });
		}
		
		for (int idx : answer) bw.append(idx + " ");
		bw.flush();
	}
}
