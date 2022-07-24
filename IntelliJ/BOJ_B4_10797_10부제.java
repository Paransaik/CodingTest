import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B4_10797_10부제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (st.nextToken().contains(String.valueOf(num))) cnt++;
        }
        System.out.println(cnt);
    }
}
