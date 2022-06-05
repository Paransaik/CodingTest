import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_B3_7595_Triangles {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if(n == 0) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    bw.append("*");
                }
                bw.append("\n");
            }
        }
        bw.flush();
    }
}
