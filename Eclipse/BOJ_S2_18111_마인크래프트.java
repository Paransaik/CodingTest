package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_18111_마인크래프트 {
	static int N, M, B;
	static int[][] arrange = new int[257][2];
	static int[] startIdx = new int[2]; // 1초, 삽입
	static int[] endIdx = new int[2]; // 2초, 제거

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		B = Integer.parseInt(st.nextToken()); // 인벤에 들어있는 블럭 개수 < 257

		int node;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				node = Integer.parseInt(st.nextToken());
				arrange[node][0] = node;
				arrange[node][1] += 1;
			}
		}

		findStartIdx();
		findEndIdx();
		int time = 0;
		while (startIdx[0] != endIdx[0]) {
			// endIdx[1] * 2 < startIdx[1] // 까는 것보다 제거하는 게 더 빠름
			if (endIdx[1] * 2 < startIdx[1] || B < startIdx[1]) { // 덮는게 불가능 할 경우, 제일 높은 층 제거
				time += 2 * endIdx[1];
				B += endIdx[1];
				arrange[endIdx[0] - 1][0] = endIdx[0] - 1;
				arrange[endIdx[0] - 1][1] += endIdx[1];
				arrange[endIdx[0]][1] = 0;
				findEndIdx();
			} else { // 블럭 개수가 얊은 층 덮을 수 있으면 제일 얊은 층 덮기
				time += startIdx[1];
				B -= startIdx[1];
				arrange[startIdx[0] + 1][0] = startIdx[0] + 1;
				arrange[startIdx[0] + 1][1] += startIdx[1];
				arrange[startIdx[0]][1] = 0;
				findStartIdx();
			}
		}

		bw.append(String.valueOf(time)).append(" ").append(String.valueOf(startIdx[0]));
		bw.flush();

	}

	public static void findStartIdx() {
		for (int i = 0; i < 257; i++) {
			if (arrange[i][1] != 0) {
				startIdx[0] = arrange[i][0];
				startIdx[1] = arrange[i][1];
				break;
			}
		}
	}

	public static void findEndIdx() {
		for (int i = 256; i > -1; i--) {
			if (arrange[i][1] != 0) {
				endIdx[0] = arrange[i][0];
				endIdx[1] = arrange[i][1];
				break;
			}
		}
	}
}
