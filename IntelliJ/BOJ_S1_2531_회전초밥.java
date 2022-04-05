import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S1_2531_회전초밥 {
    static int N, D, K, C;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시 수
        D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        Set<Integer> s = new HashSet<>();
        int[] sushi = new int[N * 2];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sushi[i] = num;
            sushi[i + N] = num;
        }
        int start = 0;
        int end = K - 1;
        int cnt, ans = Integer.MIN_VALUE;
        while (end != N + K) {
            s.clear();
            if(sushi[start] != C){
                s.add(sushi[start]);
                cnt = 1;
            } else cnt = 0;

            for (int j = start + 1; j <= end; j++) {
                if (sushi[j] != C && !s.contains(sushi[j])) {
                    s.add(sushi[j]);
                    cnt++;
                }
            }
            start++;
            end++;
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans + 1);
    }
}