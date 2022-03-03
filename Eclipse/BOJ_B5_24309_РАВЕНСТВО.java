package Eclipse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class BOJ_B5_24309_РАВЕНСТВО {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger a = new BigInteger(br.readLine(), 10);
		BigInteger b = new BigInteger(br.readLine(), 10);
		BigInteger c = new BigInteger(br.readLine(), 10);
		
		System.out.println(b.subtract(c).divide(a));
	}
}