import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BOJ_S3_9375_패션왕신해빈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> m = new HashMap<>();
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            m.clear();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String s = br.readLine().split(" ")[1];
                System.out.println(s);
                m.put(s, m.getOrDefault(s, 0) + 1);
            }
            int num = 1;
            for (Integer value : m.values()) {
                num *= (value + 1);
            }
            bw.append(String.valueOf(num - 1)).append("\n");
        }
        bw.flush();
    }
}
