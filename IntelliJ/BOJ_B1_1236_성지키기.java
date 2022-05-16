import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_1236_성지키기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[] rA = new boolean[r];
        boolean[] cA = new boolean[c];

        for (int i = 0; i < r; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if(line[j] == 'X'){
                    rA[i] = true;
                    cA[j] = true;
                }
            }
        }
        int rCnt = 0, cCnt = 0;
        for (int i = 0; i < r; i++) {
            if(!rA[i]) rCnt++;
        }
        for (int i = 0; i < c; i++) {
            if(!cA[i]) cCnt++;
        }
        System.out.println(Math.max(rCnt, cCnt));
    }
}
