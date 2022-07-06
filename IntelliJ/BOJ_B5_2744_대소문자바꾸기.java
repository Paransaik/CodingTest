import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B5_2744_대소문자바꾸기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("");
        for (int i = 0, len = word.length; i < len; i++) {
            if (word[i].equals(word[i].toLowerCase())) System.out.print(word[i].toUpperCase());
            else System.out.print(word[i].toLowerCase());
        }
    }
}
