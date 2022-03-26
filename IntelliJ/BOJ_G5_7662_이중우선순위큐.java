import java.io.*;
import java.util.*;

public class BOJ_G5_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            min.clear();
            max.clear();
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
                        if (num == -1 && !min.isEmpty()){
                            ArrayList.remove(min.poll());
                        }
                        else if (!max.isEmpty()) {
                            max.poll();
//                            min.poll();
                        }
                        break;
                }
                for (Integer integer : min) {
                    System.out.print(integer + " ");
                }
                System.out.println();
                for (Integer integer : max) {
                    System.out.print(integer + " ");
                }
                System.out.println();
                System.out.println();
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
