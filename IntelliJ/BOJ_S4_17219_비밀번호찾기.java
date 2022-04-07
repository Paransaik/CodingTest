import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S4_17219_비밀번호찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int I = Integer.parseInt(st.nextToken());
        int O = Integer.parseInt(st.nextToken());

        Map<String, String> m = new HashMap<>();
        for (int i = 0; i < I; i++) {
            st = new StringTokenizer(br.readLine());
            m.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < O; i++) {
            bw.append(m.get(br.readLine())).append("\n");
        }
        bw.flush();
    }
}
