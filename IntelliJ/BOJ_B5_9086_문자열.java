import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B5_9086_문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s = br.readLine();
            System.out.println(s.charAt(0) + "" + s.charAt(s.length() - 1));
        }
    }
}
