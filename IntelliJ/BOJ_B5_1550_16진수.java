import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B5_1550_16진수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine(), 16);
        System.out.println(a);
    }
}
