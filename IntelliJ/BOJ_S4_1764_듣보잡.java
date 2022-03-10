import java.io.*;
import java.util.*;

public class BOJ_S4_1764_듣보잡 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> s = new HashSet<>();
        List<String> l = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (s.contains(name)) {
                cnt++;
                l.add(name);
            }
        }
        Collections.sort(l);
        for (String s1 : l) {
            sb.append(s1).append("\n");
        }
        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
    }
}