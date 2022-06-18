import java.util.*;

public class PRO_L3_42628_이중우선순위큐 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"I 7", "I 5", "I -5", "D -1"});
        s.solution(new String[]{"I 16", "D 1"});
    }

    static class Solution {
        public int[] solution(String[] operations) {
            TreeMap<Integer, Integer> t = new TreeMap<>();

            for (String operation : operations) {
                String[] line = operation.split(" ");
                int num = Integer.parseInt(line[1]);
                switch (line[0]) {
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

            int[] answer = new int[2];
            if (!t.isEmpty()) {
                answer[0] = t.lastKey();
                answer[1] = t.firstKey();
            }
            return answer;
        }
    }
}
