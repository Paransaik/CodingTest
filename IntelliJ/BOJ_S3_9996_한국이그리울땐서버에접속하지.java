import java.io.*;
import java.util.regex.Pattern;

public class BOJ_S3_9996_한국이그리울땐서버에접속하지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        String[] word = br.readLine().split("\\*");
        String s = String.format("^%s.*%s$", word[0], word[1]);
        while (tc-- > 0) {
            bw.append((Pattern.matches(s, br.readLine()) ? "DA" : "NE")).append("\n");
        }
        bw.flush();
    }
}
