import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_13300_방배정 {
    static int N, K, cnt = 0;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[7][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            if (sex == 0) arr[Integer.parseInt(st.nextToken())][0]++;
            else arr[Integer.parseInt(st.nextToken())][1]++;
        }

        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] != 0) cnt += (int) Math.ceil((float) arr[i][j] / K);
            }
        }
        System.out.println(cnt);
    }
}