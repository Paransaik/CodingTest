import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B5_23037_5의수난 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.pow(num.charAt(i) - '0', 5);
        }
        System.out.println(sum);
    }
}