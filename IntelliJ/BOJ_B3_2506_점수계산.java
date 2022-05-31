import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_2506_점수계산 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score = 1, sum = 0;
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1){
                sum += score;
                score++;
            } else score = 1;
        }
        System.out.println(sum);
    }
}
