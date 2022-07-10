import java.util.Arrays;
import java.util.PriorityQueue;

public class PRO_L1_42889_실패율 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(5, new int[]{3, 3, 3, 3})));
    }

    static class Solution {
        public int[] solution(int N, int[] stages) {
            PriorityQueue<double[]> q = new PriorityQueue<>((o1, o2) -> Double.compare(o1[1], o2[1]) == 0 ? (int) o1[0] - (int) o2[0] : ((Double.compare(o1[1], o2[1]) < 0) ? 1 : -1));

            int[] dp = new int[N + 1];
            int len = stages.length;

            for (int stage : stages) dp[stage - 1]++;

            int sum = len;
            for (int i = 0; i < N; i++) {
                q.offer(new double[]{i + 1, (sum == 0) ? 0 : (double) dp[i] / sum});
                sum -= dp[i];
            }

            int size = q.size();
            int[] answer = new int[size];
            for (int i = 0; i < size; i++) {
                answer[i] = (int) q.poll()[0];
            }

            return answer;
        }
    }
}
