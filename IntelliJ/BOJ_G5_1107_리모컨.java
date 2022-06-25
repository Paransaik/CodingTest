import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
0
9
0 1 2 3 4 5 6 7 8
* */
public class BOJ_G5_1107_리모컨 {
    static final int maxChannel = 500000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int channel = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        String[] btn = new String[num];
        if (num != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num; i++) {
                btn[i] = st.nextToken();
            }
        }
        int min = Integer.MAX_VALUE;
        if (channel != 100) {
            boolean flag;
            for (int i = 0; i <= maxChannel * 2; i++) {
                flag = true;
                String s = Integer.toString(i);
                for (int j = 0; j < num; j++) {
                    if (s.contains(btn[j])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    min = Math.min(min, s.length() + Math.abs(channel - i));
                    min = Math.min(min, s.length() + Math.abs(channel - 100));
                }
            }
        } else min = 0;
        System.out.println(min);
    }
}