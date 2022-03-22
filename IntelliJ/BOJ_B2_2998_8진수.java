import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B2_2998_8진수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        switch (a.length() % 3){
            case 1: a = "00" + a; break;
            case 2: a = "0" + a; break;
            default: break;
        }
        char[] binary = a.toCharArray();
        String num = "";
        for (int i = 0; i < binary.length; i += 3) {
            num += (binary[i] - '0') * 4 + (binary[i + 1] - '0') * 2 + (binary[i + 2] - '0');
        }
        System.out.println(num);
    }
}
