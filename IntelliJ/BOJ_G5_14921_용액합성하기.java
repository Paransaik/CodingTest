import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14921_용액합성하기 {
    static int N;
    static long max = Long.MAX_VALUE, ans = 0;
    static long[] pit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pit = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pit[i] = Long.parseLong(st.nextToken());
        }
        pointer();
        System.out.println(ans);
    }

    public static void pointer() {
        int l = 0, r = pit.length - 1;
        long sum;

        while (l < r) {
            sum = pit[l] + pit[r];
            if (Math.abs(sum) < max) {
                max = Math.abs(sum);
                ans = sum;
            }
            if (sum < 0) l++;
            else r--;
        }
    }
}
