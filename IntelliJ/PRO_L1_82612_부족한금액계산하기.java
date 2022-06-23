public class PRO_L1_82612_부족한금액계산하기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(3, 20, 4);
    }

    static class Solution {
        public long solution(int price, int money, int count) {
            int mul = 0;
            for (int i = 1; i <= count; i++) mul += i;
            long cost = (long) price * mul - money;
            return (cost < 0) ? 0 : cost;
        }
    }
}
