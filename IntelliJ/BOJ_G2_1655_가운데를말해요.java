import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_G2_1655_가운데를말해요 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        int mid = Integer.parseInt(br.readLine());
        bw.append(String.valueOf(mid)).append("\n");

        while (N-- > 1) {
            int input = Integer.parseInt(br.readLine());
            if (mid >= input) min.offer(input);
            else max.offer(input);

            if (max.size() - min.size() > 1) {
                min.offer(mid);
                mid = max.poll();
            } else if (min.size() > max.size()) {
                max.offer(mid);
                mid = min.poll();
            }

            bw.append(String.valueOf(mid)).append("\n");
        }
        bw.flush();
    }
}