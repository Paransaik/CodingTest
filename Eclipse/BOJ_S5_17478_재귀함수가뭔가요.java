package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_S5_17478_재귀함수가뭔가요 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static String o = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static String tw = "\"재귀함수가 뭔가요?\"\n";
	static String[] th = { "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" };
	static String fo = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String fi = "____";
	static String s = "라고 답변하였지.\n";

	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		bw.append(o);
		recursive(0);
		bw.flush();
	}

	public static void recursive(int cnt) throws Exception {
		if (cnt == N) {
			div(cnt);
			bw.append(tw);
			div(cnt);
			bw.append(fo);
			div(cnt);
			bw.append(s);
			return;
		}

		div(cnt);
		bw.append(tw);
		for (int i = 0; i < 3; i++) {
			div(cnt);
			bw.append(th[i]);
		}
		recursive(cnt + 1);
		div(cnt);
		bw.append(s);
	}

	public static void div(int rep) throws Exception {
		for (int i = 0; i < rep; i++) bw.append(fi);
	}
}
