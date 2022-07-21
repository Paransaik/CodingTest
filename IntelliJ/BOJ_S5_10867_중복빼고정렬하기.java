import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S5_10867_중복빼고정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        List<Integer> l = new LinkedList<>();
        boolean[] check = new boolean[2001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!check[n + 1000]) {
                l.add(n);
                check[n + 1000] = true;
            }
        }

        Collections.sort(l);
        for (Integer integer : l) {
            bw.append(String.valueOf(integer)).append(" ");
        }
        bw.flush();
    }
}
