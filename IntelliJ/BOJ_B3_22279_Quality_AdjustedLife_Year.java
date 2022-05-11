import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_22279_Quality_AdjustedLife_Year {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        float sum = 0;
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            sum += Float.parseFloat(st.nextToken()) * Float.parseFloat(st.nextToken());
        }
        System.out.printf("%.3f", sum);
    }
}
