package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_B3_20361_일우는야바위꾼 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, X, K, a, b, temp, answer;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 종이컵 개수
		X = Integer.parseInt(st.nextToken()); // 찾을 인덱스
		K = Integer.parseInt(st.nextToken()); // 바꾸는 횟수

		arr = new int[N]; // 종이컵을 담을 배열 생성

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1; // 종이컵에 숫자 삽입 1~N
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken()); // 바꿀 위치 a
			b = Integer.parseInt(st.nextToken()); // 바꿀 위치 b

			temp = arr[a - 1]; // 유명한 swap Algo
			arr[a - 1] = arr[b - 1];
			arr[b - 1] = temp;
		}

		for (int i = 0; i < N; i++) { // 찾아야 하는 종이컵의 위치의
			if (arr[i] == X) { // 인덱스를 구함
				answer = i + 1;
			}
		}
		bw.append(answer + "\n"); // 출력양식 맞추기

		bw.flush(); // 출력
		bw.close(); // 자원 해제
	}

}
