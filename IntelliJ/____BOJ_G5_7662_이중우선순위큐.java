import java.io.*;
import java.util.*;

public class ____BOJ_G5_7662_이중우선순위큐 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<Long> min = new PriorityQueue<>();
        PriorityQueue<Long> max = new PriorityQueue<>(Collections.reverseOrder());

        Stack<Long> minS = new Stack<>();
        Stack<Long> maxS = new Stack<>();

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
                Long num = Long.parseLong(st.nextToken());
                switch (oper) {
                    case "I":
                        min.add(num);
                        max.add(num);
                        break;
                    case "D":
                        if (num == -1 && !min.isEmpty()) minS.add(min.poll());
                        else if (num == 1 && !max.isEmpty()) maxS.add(max.poll());
                        break;
                }
                while (!maxS.isEmpty() && (maxS.peek() == min.peek())) {
                    maxS.pop();
                    min.poll();
                }
                while (!minS.isEmpty() && (minS.peek() == max.peek())) {
                    minS.pop();
                    max.poll();
                }
            }

            System.out.println(min);
            System.out.println(max);

            for (Long aLong : maxS) System.out.print(aLong);
            System.out.println();
            for (Long aLong : minS) System.out.print(aLong);
            System.out.println();

            if (max.isEmpty() || min.isEmpty()) {
                bw.append("EMPTY").append("\n");
            } else bw.append(String.valueOf(max.poll())).append(" ").append(String.valueOf(min.poll())).append("\n");
        }
        bw.flush();
    }
}
