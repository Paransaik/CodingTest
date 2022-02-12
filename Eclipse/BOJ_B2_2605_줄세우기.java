package Eclipse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_B2_2605_줄세우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws Exception {
		LinkedList<Integer> lst = new LinkedList<>();

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			Collections.reverse(lst);
			lst.add(Integer.parseInt(st.nextToken()), i);
			Collections.reverse(lst);
		}
		for(Integer itg: lst) System.out.print(itg + " ");
	}

}
