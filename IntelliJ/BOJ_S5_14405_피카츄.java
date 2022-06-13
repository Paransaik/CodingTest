import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_S5_14405_피카츄 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String REGEX = "(pi|ka|chu)*";
        Pattern p = Pattern.compile(REGEX);
        if (p.matcher(br.readLine()).matches()) System.out.println("YES");
        else System.out.println("NO");
    }
}
