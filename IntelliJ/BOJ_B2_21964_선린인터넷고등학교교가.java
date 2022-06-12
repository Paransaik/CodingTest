import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B2_21964_선린인터넷고등학교교가 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        System.out.println(s.substring(s.length()-5));
    }
}
