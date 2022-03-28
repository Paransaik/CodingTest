import java.io.*;
import java.util.*;

public class ____BOJ_G5_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        Stack<Integer> minS = new Stack<>();
        Stack<Integer> maxS = new Stack<>();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            min.clear();
            max.clear();
            minS.clear();
            maxS.clear();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                switch (oper) {
                    case "I":
                        min.add(num);
                        max.add(num);
                        break;
                    case "D":
                        if (num == -1 && !min.isEmpty()) {
                            minS.add(min.poll());
                        } else if (!max.isEmpty()) {
                            maxS.add(max.poll());
                        }
                        break;
                }
                while (!maxS.isEmpty() && maxS.peek().equals(min.peek())) {
                    maxS.pop();
                    min.poll();
                }
                while (!minS.isEmpty() && minS.peek().equals(max.peek())) {
                    minS.pop();
                    max.poll();
                }
            }
            if (max.isEmpty() || min.isEmpty()) {
                bw.append("EMPTY").append("\n");
                continue;
            }
            bw.append(String.valueOf(max.poll())).append(" ").append(String.valueOf(min.poll())).append("\n");
        }
        bw.flush();
    }
}
