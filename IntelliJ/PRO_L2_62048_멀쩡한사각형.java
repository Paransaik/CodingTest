public class PRO_L2_62048_멀쩡한사각형 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, 12));
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
