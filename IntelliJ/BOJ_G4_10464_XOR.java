import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_G4_10464_XOR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int ms = s + 4 - (s % 4);
            int me = e - (e % 4);

            int ans = 0;
            for (int i = s; i < ms; i++) ans ^= i;
            for (int i = me; i <= e; i++) ans ^= i;

            bw.append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }
}