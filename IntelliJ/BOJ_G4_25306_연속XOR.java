import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_G4_25306_연속XOR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger s = new BigInteger(st.nextToken());
        BigInteger e = new BigInteger(st.nextToken());
        BigInteger ans = new BigInteger("0");
        for (BigInteger i = s; i.compareTo(e) <= 0; i = i.add(BigInteger.ONE)) {
            ans = ans.xor(i);
        }
        System.out.println(ans);
    }
}