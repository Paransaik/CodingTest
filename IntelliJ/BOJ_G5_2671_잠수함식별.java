import java.io.*;
import java.util.regex.Pattern;

public class BOJ_G5_2671_잠수함식별 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(Pattern.matches("(100+1+|01)+", br.readLine()) ? "SUBMARINE" : "NOISE").append("\n");
        bw.flush();
    }
}
