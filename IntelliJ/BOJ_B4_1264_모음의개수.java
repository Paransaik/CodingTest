import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_B4_1264_모음의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = "[aeiou]";

        while (true) {
            char[] word = br.readLine().toLowerCase().toCharArray();
            if (word[0] == '#') break;
            int len = word.length, cnt = 0;
            for (int i = 0; i < len; i++) {
                if (Pattern.matches(p, String.valueOf(word[i]))) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
