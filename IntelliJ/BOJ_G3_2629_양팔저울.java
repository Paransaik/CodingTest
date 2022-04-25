import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_G3_2629_양팔저울 {
    // 구슬의 무게 최댓값
    static final int MAX = 40000;
    // 추, 구슬의 개수
    static int N, B;
    // 추, 구슬의 무게를 저장하기 위한 배열
    static int[] weight, bead;
    // dp 배열
    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 추의 개수
        N = Integer.parseInt(br.readLine());
        // 2차원 냅색
        dp = new boolean[N + 1][MAX + 1];
        // 추의 무게
        weight = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        // 구슬의 개수
        B = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        // 확인 하는 구슬의 무게
        bead = new int[B];
        for (int i = 0; i < B; i++) {
            bead[i] = Integer.parseInt(st.nextToken());
        }

        // dp 재귀호출
        dpRecursive(0, 0);

        for (int i = 0; i < B; i++) {
            // dp[N][bead[i]]가 ture인 경우 Y
            if (dp[N][bead[i]]) bw.append("Y ");
            // 아닌 경우 N
            else bw.append("N ");
        }
        // 출력
        bw.flush();
    }

    public static void dpRecursive(int num, int w) {
        // 기저 조건, num 값이 N보다 크거나 이미 true인 경우
        if (num > N || dp[num][w]) return;
        // 추로 잴 수 있는 가능한 무게
        dp[num][w] = true;
        // 현재 추의 무게 true
        dpRecursive(num + 1, w);
        // 현재 추의 무게 + 새로운 추의 무게 true
        dpRecursive(num + 1, w + weight[num]);
        // 현재 추의 무게 - 새로운 추의 무게 ture
        // 음수일 경우에 반대편에 추를 올려 확일 할 수 있으므로 절댓값 사용
        dpRecursive(num + 1, Math.abs(w - weight[num]));
    }
}
