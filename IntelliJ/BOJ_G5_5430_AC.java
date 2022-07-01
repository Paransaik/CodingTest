import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_G5_5430_AC {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> q = new LinkedList<>();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            q.clear();
            char[] oper = br.readLine().toCharArray();
            int cnt = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] number = s.substring(1, s.length() - 1).split(",");
            q.addAll(Arrays.asList(number));
            execute(oper, q, cnt);
        }
        bw.flush();
    }

    public static void execute(char[] o, Deque<String> q, int cnt) throws Exception {
        int state = 0;
        for (char c : o) {
            switch (c) {
                case 'R':
                    state ^= 1;
                    break;
                case 'D':
                    if (cnt == 0) {
                        bw.append("error").append("\n");
                        return;
                    }
                    if (state == 0) q.poll();
                    else q.pollLast();
                    cnt--;
                    break;
            }
        }
        bw.append("[");
        if (state == 1) {
            Collections.reverse((List<?>) q);
        }
        bw.append(String.join(",", q));
        bw.append("]").append("\n");
    }
}
