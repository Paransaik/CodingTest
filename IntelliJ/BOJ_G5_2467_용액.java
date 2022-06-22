import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2467_용액 {
    static int N;
    static long max = Long.MAX_VALUE;
    static long[] pit, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pit = new long[N];
        ans = new long[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pit[i] = Long.parseLong(st.nextToken());
        }

        pointer();

        for (int i = 0; i < 2; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void pointer() {
        int l = 0, r = pit.length - 1;
        long sum;

        while (l < r) {
            sum = pit[l] + pit[r];
            if (Math.abs(sum) < max) {
                ans[0] = pit[l];
                ans[1] = pit[r];
                max = Math.abs(sum);
            }
            if (sum < 0) l++;
            else r--;
        }
    }
}
