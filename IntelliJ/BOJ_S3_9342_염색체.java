import java.io.*;
import java.util.regex.Pattern;

public class BOJ_S3_9342_염색체 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "[A-F]?A+F+C+[A-F]?$";
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            bw.append((Pattern.matches(s, br.readLine()) ? "Infected!" : "Good")).append("\n");
        }
        bw.flush();
    }
}
