public class PRO_L2_43165_타겟넘버 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    static class Solution {
        static int ans = 0, sum;
        static int numLen = 0;
        static boolean[] isSelected;

        public int solution(int[] numbers, int target) {
            numLen = numbers.length;
            isSelected = new boolean[numLen];
            dfs(numbers, target, 0);
            return ans;
        }

        static public void dfs(int[] nb, int t, int idx) {
            if (idx == numLen) {
                sum = 0;
                for (int i = 0; i < numLen; i++) {
                    sum += (isSelected[i]) ? nb[i] : (-1 * nb[i]);
                }
                if (sum == t) ans++;
                return;
            }

            isSelected[idx] = true;
            dfs(nb, t, idx + 1);
            isSelected[idx] = false;
            dfs(nb, t, idx + 1);
        }
    }
}
