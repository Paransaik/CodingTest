import java.io.*;
import java.util.*;

public class BOJ_G5_7662_이중우선순위큐 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        TreeMap<Integer, Integer> t = new TreeMap<>();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            t.clear();

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                switch (oper) {
                    case "I":
                        t.put(num, t.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (!t.isEmpty()) {
                            int key = (num == 1) ? t.lastKey() : t.firstKey();
                            int cnt = t.get(key) - 1;
                            if (cnt == 0) t.remove(key);
                            else t.put(key, cnt);
                        }
                        break;
                }
            }

            if (t.isEmpty()) bw.append("EMPTY").append("\n");
            else
                bw
                .append(String.valueOf(t.lastKey()))
                .append(" ")
                .append(String.valueOf(t.firstKey()))
                .append("\n");
        }
        bw.flush();
    }
}
