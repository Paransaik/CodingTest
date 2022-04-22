import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_2693_N번째큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] ans = new int[10];
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                ans[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(ans);
            bw.append(String.valueOf(ans[7])).append("\n");
        }
        bw.flush();
    }
}
