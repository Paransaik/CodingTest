import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_S4_5637_가장긴단어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        String w = "";
        while (true) {
            String[] words = br.readLine().split("[^a-zA-Z-]");
            for (String word : words) {
                if (word.equals("E-N-D")){
                    System.out.println(w.toLowerCase());
                    return;
                }
                if(word.length() > ans) {
                    ans = word.length();
                    w = word;
                }
            }
        }
    }
}
