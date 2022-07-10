import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_B1_2929_머신코드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> l = new ArrayList<>();
        char[] line = br.readLine().toCharArray();
        for (int i = 0; i < line.length; i++) {
            l.add(line[i]);
        }

    }
}
