import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S4_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, String> poket = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String po = br.readLine();
            poket.put(Integer.toString(i), po);
            poket.put(po, Integer.toString(i));
        }
        for (int i = 0; i < M; i++) {
            bw.append(poket.get(br.readLine())).append("\n");
        }
        bw.flush();
    }
}
