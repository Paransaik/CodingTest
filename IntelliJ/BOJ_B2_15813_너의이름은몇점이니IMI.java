import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B2_15813_너의이름은몇점이니IMI {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] name = br.readLine().toCharArray();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (name[i] - 'A') + 1;
        }
        System.out.println(sum);
    }
}
