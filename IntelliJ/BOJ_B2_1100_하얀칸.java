import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B2_1100_하얀칸 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int flag = 1;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if(flag == 1 && line[j] == 'F') cnt++;
                flag ^= 1;
            }
            flag ^= 1;
        }
        System.out.println(cnt);
    }
}
