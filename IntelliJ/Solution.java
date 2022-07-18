public class Solution {
    public static void main(String[] args) {
        int fac = 7;
        int sum = 1;
        for (int i = 2; i <= fac; i++) {
            sum *= i;
        }
        System.out.println(sum);

        System.out.println(7 * 6 * 5);


        Solution s = new Solution();
        System.out.println(s.solution(10, 10));
    }

    public long solution(int w, int h) {
        int sw = w, sh = h;
        while (true) {
            sw %= sh;
            if (sw == 0) break;
            sh %= sw;
            if (sh == 0) break;
        }
        return (long) w * h - (w + h - (sh + sw));
    }
}