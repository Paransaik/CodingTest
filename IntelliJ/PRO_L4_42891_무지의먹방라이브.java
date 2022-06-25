import java.util.*;

public class PRO_L4_42891_무지의먹방라이브 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 1, 1, 1}, 4);
    }

    static class Solution {
        public int solution(int[] food_times, long k) {
            int len = food_times.length;
            LinkedList<int[]> l = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                l.add(new int[]{i + 1, food_times[i]});
            }
            l.sort((Comparator.comparingInt(o -> o[1])));

            int inc = 0;
            while (k >= len && !l.isEmpty()) {
                int[] node = l.poll();
                long minus = (long) (node[1] - inc) * len;
                if (minus <= k) {
                    k -= minus;
                    len--;
                    inc = node[1];
                    while (!l.isEmpty() && l.get(0)[1] == inc) {
                        l.poll();
                        len--;
                    }
                } else {
                    k -= (k / len) * len;
                    l.addFirst(node);
                }
            }
            l.sort((Comparator.comparingInt(o -> o[0])));

            if (l.isEmpty()) return -1;
            else return l.get((int) k)[0];
        }
    }
}