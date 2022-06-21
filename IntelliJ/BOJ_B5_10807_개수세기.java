import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B5_10807_개수세기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] cnt = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            cnt[Integer.parseInt(st.nextToken()) + 100]++;
        }
        System.out.println(cnt[Integer.parseInt(br.readLine())]);
    }
}
