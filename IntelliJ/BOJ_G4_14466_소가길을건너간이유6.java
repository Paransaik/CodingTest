import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_14466_소가길을건너간이유6 {
    static int N, K, R;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));

//        Queue<int[]>

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        bfs();

    }

    public static void bfs(){

    }
}
