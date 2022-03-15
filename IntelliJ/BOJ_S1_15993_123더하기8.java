import java.io.*;

public class BOJ_S1_15993_123더하기8 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int M = 1000000009;
        final int nMax = 100000;
        int TC = Integer.parseInt(br.readLine());
        int[] odd = new int[nMax + 1]; // {1, 1, 2};
        int[] even = new int[nMax + 1]; // {0, 1, 2}
        odd[1] = odd[2] = even[2] = 1;
        odd[3] = even[3] = 2;
        for (int i = 4; i <= nMax; i++) {
            odd[i] = ((even[i - 1] + even[i - 2]) % M + even[i - 3]) % M;
            even[i] = ((odd[i - 1] + odd[i - 2]) % M + odd[i - 3]) % M;
        }
        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(odd[N])).append(" ").append(String.valueOf(even[N])).append("\n");
        }
        bw.flush();
    }
}