import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_D3_5607_조합 {
    static int N, R;
    static final int P = 1234567891;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(nCr(N, R, P))).append("\n");
        }
        bw.flush();
    }

    public static long nCr(int n, int r, long p) {
        long[] fac = new long[n + 1];
        fac[1] = 1;
        for (int i = 2; i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        // n * ((n-r)!*r!^p-2 % p)
        return (fac[n] * FLT(fac[n - r], p - 2, p) % p * FLT(fac[r], p - 2, p) % p) % p;
    }

    public static long FLT(long x, long m, long p) {
        // n * (u^p-2 % p)
        long res = 1L;
        while (m > 0) {
            if (m % 2 == 1) res = (res * x) % p;
            m >>= 1;
            x = (x * x) % p;
        }
        return res;
    }
}
