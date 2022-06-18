import java.util.*;

public class PRO_L3_42628_이중우선순위큐 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"I 7", "I 5", "I -5", "D -1"});
        s.solution(new String[]{"I 16", "D 1"});
    }

    static class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            Map<Integer, Integer> m = new HashMap<>();

            for (String operation : operations) {
                String[] line = operation.split(" ");
                int num = Integer.parseInt(line[1]);
                switch (line[0]) {
                    case "I":
                        maxQ.offer(num);
                        minQ.offer(num);
                        m.put(num, m.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (m.size() != 0) {
                            if (num == 1 && !maxQ.isEmpty()) num = maxQ.poll();
                            else if (!minQ.isEmpty()) num = minQ.poll();
                            m.put(num, m.get(num) - 1);
                            if (m.get(num) == 0) m.remove(num);
                            System.out.println(m.size());
                        }
                        break;
                }
            }

            int[] answer = new int[2];
            if (m.size() != 0) {
                List<Integer> keys = new ArrayList<>(m.keySet());
                Collections.sort(keys);

                answer[0] = keys.get(keys.size() - 1);
                answer[1] = keys.get(0);
            }
            return answer;
        }
    }
}
