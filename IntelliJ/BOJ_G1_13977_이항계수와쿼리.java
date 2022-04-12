import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G1_13977_이항계수와쿼리 {
    static int N, R;
    static final int P = 1000000007;
    static final int MAX = 4000001;

    static long[] fac = new long[MAX];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        fac[0] = fac[1] = 1;
        for (int i = 2; i < MAX; i++) {
            fac[i] = fac[i - 1] * i % P;
        }
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            System.out.println(nCr(N, R, P));
        }

    }

    public static long nCr(int n, int r, long p) {
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
