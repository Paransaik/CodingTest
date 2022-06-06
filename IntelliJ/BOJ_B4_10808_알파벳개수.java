import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B4_10808_알파벳개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int[] ahlpa = new int[26];
        for (int i = 0, len = line.length; i < len; i++) {
            ahlpa[line[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(ahlpa[i] + " ");
        }
    }
}