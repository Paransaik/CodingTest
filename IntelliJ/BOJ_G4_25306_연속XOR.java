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
        BigInteger four = new BigInteger("4");

        BigInteger aMod = s.mod(four);
        BigInteger len = four.subtract(aMod);
        for (BigInteger i = s; i.compareTo(s.add(len)) < 0; i = i.add(BigInteger.ONE)) {
            ans = ans.xor(i);
        }

        BigInteger bMod = e.mod(four);
        for (BigInteger i = e.subtract(bMod); i.compareTo(e) <= 0; i = i.add(BigInteger.ONE)) {
            ans = ans.xor(i);
        }

        System.out.println(ans);
    }
}