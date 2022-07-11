import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_S5_1316_그룹단어체커 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (tc-- > 0) {
            String s = br.readLine();
            boolean[] checked = new boolean[26];
            boolean flag = true;
            int beforeNum = s.charAt(0) - 'a';
            checked[s.charAt(0) - 'a'] = true;
            for (int i = 1, len = s.length(); i < len; i++) {
                int num = s.charAt(i) - 'a';
                if (num == beforeNum) continue;
                if (checked[num]) {
                    flag = false;
                    break;
                }
                checked[s.charAt(i) - 'a'] = true;
                beforeNum = num;
            }
            if (flag) cnt++;
        }
        System.out.println(cnt);
    }
}
