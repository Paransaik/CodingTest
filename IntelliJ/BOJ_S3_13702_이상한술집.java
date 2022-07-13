import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_13702_이상한술집 {
    static int N, K, max = Integer.MIN_VALUE;
    static int[] mgr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        mgr = new int[N];
        for (int i = 0; i < N; i++) {
            int ml = Integer.parseInt(br.readLine());
            mgr[i] = ml;
            max = Math.max(max, ml);
        }
        if (N == 0 || K == 0) System.out.println(0);
        System.out.println((K == 1) ? mgr[0] : binarySearch());
    }

    static long binarySearch() {
        long left = 0, right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            long ans = 0;
            for (int i = 0; i < N; i++) ans += mgr[i] / mid;
            if (ans < K) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
