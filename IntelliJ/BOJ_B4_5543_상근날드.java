import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_B4_5543_상근날드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            if (i < 3) min1 = Math.min(Integer.parseInt(br.readLine()), min1);
            else min2 = Math.min(Integer.parseInt(br.readLine()), min2);
        }
        bw.append(String.valueOf(min1 + min2 - 50));
        bw.flush();
    }
}
