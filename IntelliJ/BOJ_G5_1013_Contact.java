import java.io.*;
import java.util.regex.Pattern;

public class BOJ_G5_1013_Contact {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) bw.append(Pattern.matches("(100+1+|01)+", br.readLine()) ? "YES" : "NO").append("\n");
        bw.flush();
    }
}
