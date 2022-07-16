import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B5_4999_아MIM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = br.readLine().length();
        int b = br.readLine().length();
        System.out.println((a >= b) ? "go" : "no");
    }
}
