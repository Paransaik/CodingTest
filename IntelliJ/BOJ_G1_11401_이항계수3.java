import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G1_11401_이항계수3 {
    static int N, R;
    static final int P = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        System.out.println(nCr(N, R, P));
    }

    public static long nCr(int n, int r, long p) {
        long[] fac = new long[n + 1];
        fac[0] = fac[1] = 1;
        for (int i = 2; i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        return (fac[n] * FLT(fac[n - r], p - 2, p) % p
                * FLT(fac[r], p - 2, p) % p) % p;
    }

    public static long FLT(long x, long m, long p) {
        long res = 1L;
        while (m > 0) {
            if (m % 2 == 1) res = res * x % p;
            m >>= 1;
            x = x * x % p;
        }
        return res;
    }
}
