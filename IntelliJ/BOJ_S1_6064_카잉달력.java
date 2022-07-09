import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
15
40000 39999 39999 39998
40000 39999 40000 39999
40000 40000 40000 39999
40000 39998 40000 39997
39999 2 39998 2
3 40000 3 39999
40000 3 40000 3
8 2 4 2
10 12 2 12
12 10 12 10
12 10 1 1
12 6 12 6
10 1 5 1
1 10 1 5
1 1 1 1

답:
1599959999
1599960000
-1
-1
39998
39999
120000
4
12
60
1
12
5
5
1
*/
public class BOJ_S1_6064_카잉달력 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int ans = X;
            while (ans % M != X || ans % N != Y) {
                if (ans > N * M) {
                    ans = -1;
                    break;
                }
                if (ans % M == 0 && ans % N == 0) break;
                ans += M;
            }
            bw.append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }
}
