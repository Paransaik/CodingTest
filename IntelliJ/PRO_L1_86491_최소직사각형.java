public class PRO_L1_86491_최소직사각형 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int len = sizes.length;
            int r = Integer.MIN_VALUE, c = Integer.MIN_VALUE;

            for (int i = 0; i < len; i++) {
                r = Math.max(r, Math.max(sizes[i][0], sizes[i][1]));
                c = Math.max(c, Math.min(sizes[i][0], sizes[i][1]));
            }
            return r * c;
        }
    }
}
