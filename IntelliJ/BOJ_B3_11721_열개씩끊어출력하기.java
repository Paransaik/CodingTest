import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B3_11721_열개씩끊어출력하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        for (int i = 0; i < line.length; i++) {
            if (i != 0 && i % 10 == 0) {
                System.out.print("\n");
            }
            System.out.print(line[i]);
        }
    }
}
