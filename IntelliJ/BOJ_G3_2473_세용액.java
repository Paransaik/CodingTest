import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_2473_세용액 {
    static int N;
    static long max = Long.MAX_VALUE;
    static long[] pit, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pit = new long[N];
        ans = new long[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pit[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(pit);
        for (int i = 0; i < N - 2; i++) {
            pointer(i);
        }

        Arrays.sort(ans);
        for (int i = 0; i < 3; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void pointer(int idx) {
        int l = 0, r = pit.length - 1;
        long sum;

        while (true) {
            if(l == idx) l++;
            if(r == idx) r--;
            if(l >= r) break;

            sum = pit[idx] + pit[l] + pit[r];
            if (Math.abs(sum) < max) {
                ans[0] = pit[idx];
                ans[1] = pit[l];
                ans[2] = pit[r];
                max = Math.abs(sum);
            }
            if (sum < 0) l++;
            else r--;
        }
    }
}
